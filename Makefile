.PHONY: start start-web stop build build-web remove logs help

dc=docker-compose

start: ## Start container(s)
	$(dc) up -d

stop: ## Stop container(s)
	$(dc) stop

build: ## Build container(s)
	$(dc) build

remove: ## Stop container(s) and remove them
	$(dc) down -v --remove-orphans

logs: ## Show logs from container(s)
	$(dc) logs --follow

help: ## Show this help
	@echo "Targets:"
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e 's/\\$$//' | sed -e 's/\(.*\):.*##[ \t]*/    \1 ## /' | sort | column -t -s '##'
	@echo

.DEFAULT_GOAL := help
