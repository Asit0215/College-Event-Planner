#!/bin/bash

# configuration
SOURCE_DIR="/c/Users/afnan/college-event-planner/College-Event-Planner"
BACKUP_DIR="/c/Users/afnan/frontend_backups"
LOG_FILE="/c/Users/afnan/frontend_backup.log"

# creating backup
mkdir -p "$BACKUP_DIR"

# timestamp for backup
TIMESTAMP=$(date "+%Y-%m-%d_%H-%M")
BACKUP_FILE="$BACKUP_DIR/frontend_backup_$TIMESTAMP.tar.gz"

# backing up html files
tar -czf "$BACKUP_FILE" -C "$SOURCE_DIR" $(find "$SOURCE_DIR" -maxdepth 1 \( -name "*.html" -o -name "*.css" -o -name "*.js" \) -exec basename {} \;)


# shows log succes
echo "[$(date)] Backup created: $BACKUP_FILE" >> "$LOG_FILE"
