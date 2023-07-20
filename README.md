# exchange-rates-api

## Docker Run

```sh
docker-compose -f docker-compose-local.yml up && docker-compose rm -fsv
```
## Latest

```
curl --request GET \
  --url http://localhost:8080/latest
```

Response
```
{
	"base": "USD",
	"date": "2023-07-15",
	"rates": {
		"BOB": 6.904419,
		"COP": 4086.899749,
		"USD": 1.0
	}
}
```

## Exchange
```
curl --request GET \
  --url http://localhost:8080/exchange/COP/50000000/USD
```

Response
```
{
	"USD": 12234.212501110214
}
```