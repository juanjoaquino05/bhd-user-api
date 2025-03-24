# bhd-user-api
This is a REST service API intended to be used only for interview evaluation purposes.

## Requirements
* Docker Desktop: 4.37.0 (178034) (containing below components)
    * Engine: 27.4.0
    * Compose: v2.31.0-desktop.2
    * Credential Helper: v0.8.2
    * Kubernetes: v1.30.5

## Guidelines
Follow these steps to run the Application.

1. Clone this repository.
2. Build Package.
```bash 
    # Linux, MacOS
    ./mvnw clean package -Dmaven.test.skip
    
    # Windows
    mvnw.cmd clean package -Dmaven.test.skip
```

3. Run the following command:
```bash
    # Linux, Mac, Windows
    docker-compose up
```

If there is a problem running the program be sure you have installed and configured Docker correctly. (if not, open an issue in this repo)


## Disclaimers
* This is an example and intended to demonstrate to app providers a sample of how to approach an implementation. There are potentially other ways to approach it and alternatives could be considered.
* Its possible that the repo is not actively maintained.

## License
MIT

The code in this repository is covered by the included license.

## Support
Please enter an issue in the repo for any questions or problems.
