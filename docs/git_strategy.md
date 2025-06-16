# Git Branching Strategy - College Event Planner

## Main Branches
- `main`: Stable, production-ready code
- `develop`: Ongoing integration from features

## Supporting Branches
- `feature/*`: New features (e.g., login, dashboard)
- `bugfix/*`: Bug fixes from `develop`
- `hotfix/*`: Urgent fixes on `main`

## Workflow
1. Team members create `feature/*` branches from `develop`
2. After development, they push and create a pull request to `develop`
3. Git admin(me) can review and merge
4. Once `develop` is stable, it is merged into `main`
