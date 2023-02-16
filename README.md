![Node workflow](https://github.com/DApIA-Project/FDI-T-Web/actions/workflows/node.js.yml/badge.svg)
# FDI-T Web

## Generate FDI-T client using Langium

```shell
npm run langium:generate:client
```

## Generate FDI-T server using Langium
```shell
npm run langium:generate:server
```

## Build FDI-T client Docker image

```shell
npm run docker:build:client
```

## Build FDI-T server Docker image

```shell
npm run docker:build:server
```

## Build FDI-T client/server Docker image

```shell
npm run docker:compose:up
```

## Copy tools directory in .m2 directory (do this in git bash on windows)

```shell
npm run copy:dependancies:m2
```