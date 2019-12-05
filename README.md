# xy-inc
>A XY-Inc. é uma empresa especializada na produção de excelentes receptores GPS (Global Positioning System). 
 A diretoria está empenhada em lançar um dispositivo inovador que promete auxiliar pessoas na localização de ponto de interesse (POIs).

A Api fornece os seguintes serviços:
* Serviço para cadastrar pontos de interesse, com 3 atributos: Nome do POI, coordenada X
(inteiro não negativo) e coordenada Y (inteiro não negativo). Os POIs devem ser armazenados
em uma base de dados.
* Serviço para listar todos os POIs cadastrados.
* Serviço para listar POIs por proximidade. Este serviço receberá uma coordenada X e uma c
oordenada Y, especificando um ponto de referência, em como uma distância máxima (dmax) em metros. O serviço deverá retornar todos os POIs da base de dados que estejam a uma d
istância menor ou igual a d-max a partir do ponto de referência. Exemplo:

## Base de Dados:
  * 'Lanchonete' (x=27, y=12)
  * 'Posto' (x=31, y=18)
  * 'Joalheria' (x=15, y=12)
  * 'Floricultura' (x=19, y=21)
  * 'Pub' (x=12, y=8)
  * 'Supermercado' (x=23, y=6)
  * 'Churrascaria' (x=28, y=2)

Dado o ponto de referência (x=20, y=10) indicado pelo receptor GPS, e uma distância máxima d
e 10 metros, o serviço deve retornar os seguintes POIs:
  * Lanchonete
  * Joalheria
  * Pub
  * Supermercado

## Instalação do projeto

Efetue o clone do projeto ou baixe-o.
Use a IDE Eclipse, versão Lunar ou superior ou o STS( Spring Tools Suite 4).

Execute o projeto 

## Execução

Rode o projeto. Run as >> Java Application.


## Testes
* Pode se usar o sistema PostMan (https://www.getpostman.com/).

_Método: GET: xy-inc/poi/_

Lista os pontos cadastrados.

_Método: GET: xy-inc/poi/proximidade_

Parametros: x, y, dmax

x - coordenada X, numero inteiro.

y - coordenada Y, numero inteiro.

dmax - distancia entre os pontos, numero inteiro.

Lista os pontos cadastrados proximos ao parametro informado.

_Método: POST: xy-inc/poi/_

Json: 

{nome:"valor", coordenadaX:"x", coordenadaY:"y"}

Sendo x e y, valores numerico sinteiros.

Cadastra um ponto de interesse.

* O arquivo _PoiControllerTest_, pode ser executado para rodar os testes automáticos.
