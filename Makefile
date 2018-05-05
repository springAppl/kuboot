# registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
IMAGE_NAME = springapp/kuboot

.PHONY: build
build:
	docker build -t $(IMAGE_NAME) .

.PHONY: test
test:
	docker build -t $(IMAGE_NAME)-candidate .
	IMAGE_NAME=$(IMAGE_NAME)-candidate test/run
