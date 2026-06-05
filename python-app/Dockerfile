# ------------------- DEVELOPMENT -------------------
# use python:3.12-alpine as a base image
# link to the image: https://hub.docker.com/layers/library/python/3.12-alpine
FROM python:3.12-alpine AS development

# create /app folder inside the image which will be a root folder
WORKDIR /app

# accept NAME as an argument at build time
ARG NAME
# set NAME into the image as env variable
ENV NAME=${NAME}

# copy pyproject.toml file into the root folder
COPY pyproject.toml .
# install dependencies from pyproject.toml without caching to minimize the image size,
# including optional dev dependencies (pytest)
RUN pip install --no-cache-dir ".[dev]"

# copy app.py into the root folder
COPY app.py .

# copy tests/ folder with test_app.py into the root folder
COPY tests/ ./tests/
# run tests at build time. If tests fail, the image build fails
RUN pytest tests/test_app.py

# run the script using 'python3 app.py' command
CMD ["python3", "app.py"]

# ------------------- PRODUCTION -------------------
# use the same base image as in development
FROM python:3.12-alpine AS production

# create a root folder /app inside the image
WORKDIR /app

# accept NAME as an argument at build time and set it into the image as env variable
ARG NAME
ENV NAME=${NAME}

# copy pyproject.toml from development stage
COPY --from=development /app/pyproject.toml .

# install only production dependencies (pytest is not needed)
RUN pip install --no-cache-dir .

# copy app.py from development stage
COPY --from=development /app/app.py .

# run the script using 'python3 app.py' command
CMD ["python3", "app.py"]
