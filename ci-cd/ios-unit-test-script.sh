#!/bin/bash
set -e

# Arguments
scheme=$1

# Find iOS Simulator devices
device=`xcrun xctrace list devices 2>&1 | grep -oE 'iPhone.*?[^\(]+' | head -1 | awk '{$1=$1;print}' | sed -e "s/ Simulator$//"`
platform="iOS Simulator"
destination="platform=$platform,name=$device"

echo "Current scheme: TravelNavigation"
echo "Start building with destination: $destination"

# Build application
set -o pipefail && xcodebuild build-for-testing \
    -workspace ../ios/TravelNavigation/TravelNavigation.xcworkspace \
    -scheme "$scheme" \
    -destination "$destination" \
    -quiet

echo "Build successful"
# echo "Start testing"

# # Start running tests
# set -o pipefail && xcodebuild test-without-building \
#     -workspace ../ios/TravelNavigation/TravelNavigation.xcworkspace \
#     -scheme "$scheme" \
#     -sdk iphonesimulator \
#     -destination "$destination" \
#     -quiet
# echo "Test successful"
