# sub-fase2-clean-architecture
Repositório do sistema de revendas de carros

### O que é o projeto?
- Sistema backend de revendas de carros nomeado como 'Carsales', algo como 'Venda de carros'. Criativo, não?! rs
- O projeto atende as necessidades características de uma concessionária, realizando as seguintes funções:

  * Cadastro de veículos com todas as informações necessárias para operar vendas;
  * Listagem dos veículos à venda por ordem crescente de preço;
  * Listagem de veículos vendidos, com a mesma ordem;
  * Edição dos dados destes veículos;
  * Simulação de aprovação/reprovação de vendas, como uma financeira.

### Tecnologias utilizadas
- Spring Boot 3.2
- Postgres 15
- Java 17
- Docker
- Google Cloud Platform (GCP)
- GKE (Google Kubernetes Engine)
- External Load Balancer
- Network Endpoint Group (NEGs)

  
### Como rodar a aplicação via docker-compose?

Para executar a aplicação completa localmente, execute estes dois passos:

1º - baixe o projeto em seu computador:
```bash
git clone https://github.com/mvsouza30/sub-fase2-clean-architecture.git
```

2º - No diretório raíz do projeto, execute:
```bash
docker-compose up -d
```

### Como rodar a aplicação via kubernetes?

Para executar a aplicação completa, navegue ao diretório 'K8S' e execute um script por vez. 
Observe que os diretórios estão enumerados e categorizados, você pode seguir a sequência. 

```bash
kubectl apply -f 01-configmaps/configmap.yaml
kubectl apply -f 02-deployments/app-deployment.yaml
kubectl apply -f 02-deployments/db-deployment.yaml
kubectl apply -f 03-secrets/db-secrets.yaml
kubectl apply -f 04-services/app-services.yaml
kubectl apply -f 04-services/db-services.yaml
kubectl apply -f 05-ingress/ingress.yaml
```
(Trabalhoso, né? Mas será legal quando precisar evoluir recursos ;)

> O kubernetes vai rodar as imagens `mvsouza30/app-prod:v1` e `mvsouza30/db-prod:v1`.


### Swagger

Para acessar o Swagger da aplicação, acesse o caminho [http://ip_externo_do_alb/swagger-ui/index.html] (http://localhost:8080/swagger-ui/index.html) da aplicação.

Caso queira uma referência do projeto, acesse a imagem 'infra.jpg' contida no diretório raíz também

E pronto, é isso!

Vídeo completo no Youtube:
https://www.youtube.com/watch?v=F9nTlwc4bnI&ab_channel=MarcosSouza

