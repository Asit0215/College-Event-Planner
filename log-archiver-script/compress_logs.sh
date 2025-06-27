#!/bin/bash

# Folder where log files are kept
LOG_DIR="./logs"

# Folder to store compressed files
BACKUP_DIR="./backup"

# Create backup folder if it doesn’t exist
mkdir -p "$BACKUP_DIR"

# Compress each .log file from logs folder and save in backup folder
for file in "$LOG_DIR"/*.log; do
  if [ -f "$file" ]; then
    gzip -c "$file" > "$BACKUP_DIR/$(basename "$file").gz"
    echo "Compressed: $(basename "$file")"
  fi
done

# Final message
echo "✅ All logs compressed and moved to backup!"

