# text-analyzr is a simple tool for analize words occurrences in the text.

## Endpoints:


### Text analize:
#### URL: http://localhost:8080/api/v1/analyze
#### Method: POST
#### Body:
```
{
    "text": "Dzisiaj wydarzy się coś pięknego. Jestem tego pewien."
}
```


### Search word analized before:
#### URL: http://localhost:8080/api/v1/word
#### Method: POST
#### Body:
```
{
    "word": "pięknego"
}
```
