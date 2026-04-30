#!/usr/bin/env bash

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"

FAILED_PROJECTS=()
SUCCESS_COUNT=0
TOTAL_PROJECTS=0

echo "========================================="
echo "Building All Projects"
echo "========================================="
echo ""

build_project() {
    local project_path=$1
    local project_name=$(basename "$project_path")
    
    if [ -f "$project_path/pom.xml" ]; then
        echo "----------------------------------------"
        echo "Building: $project_name"
        echo "Path: $project_path"
        echo "----------------------------------------"
        
        cd "$project_path" || return 1
        
        if mvn clean package -Dmaven.test.skip=true; then
            echo "✅ SUCCESS: $project_name"
            ((SUCCESS_COUNT++))
        else
            echo "❌ FAILED: $project_name"
            FAILED_PROJECTS+=("$project_name")
        fi
        
        cd "$PROJECT_ROOT" || return 1
        echo ""
        ((TOTAL_PROJECTS++))
    fi
}

build_language_projects() {
    local lang=$1
    local lang_dir="$PROJECT_ROOT/$lang"
    
    if [ -d "$lang_dir" ]; then
        echo "Building $lang projects..."
        echo ""
        
        for project in "$lang_dir"/*; do
            if [ -d "$project" ]; then
                build_project "$project"
            fi
        done
    fi
}

build_language_projects "en"
build_language_projects "cn"

echo "========================================="
echo "Build Summary"
echo "========================================="
echo "Total Projects: $TOTAL_PROJECTS"
echo "Successful: $SUCCESS_COUNT"
echo "Failed: ${#FAILED_PROJECTS[@]}"
echo ""

if [ ${#FAILED_PROJECTS[@]} -gt 0 ]; then
    echo "❌ Failed Projects:"
    for project in "${FAILED_PROJECTS[@]}"; do
        echo "  - $project"
    done
    echo ""
    exit 1
else
    echo "✅ All projects built successfully!"
    echo ""
    exit 0
fi
