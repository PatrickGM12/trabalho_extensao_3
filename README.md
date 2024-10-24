﻿# Trabalho de Extensao 3
 Passo a passo para atualizar do repositório
 ## Primeira vez por aqui
 * Baixar GIT [Clique Aqui](https://git-scm.com/downloads)
 * Baixar VsCode [Clique Aqui](https://code.visualstudio.com/)
 * acesse a pasta **C:/sts** com a IDE VSCODE
 * Abra o terminal e certifique-se que está no diretório correto
 * execute os seguintes comandos
 * * git init
   * git config --global user.name "seuNomeDeUsuario"
   * git config --global user.email "meu_nome@email.com"
   * git clone https://github.com/amorimgg7/trabalho_extensao_3.git --branch nomeDoBranch
## Subir Atualização
obs: Quando voce realizar modificações no código e desejar subir para o repositório na nuvem
* Abra o terminal e certifique-se que está no diretório **C:/sts**
* Execute os seguintes comandos
* * git add .
  * git status ou git diff
  * git commit -m "Comentário/Observação"
  * git push origin main
## Puxar Atualizar
* Acessar a pasta **C:/sts** com IDE VsCode
* Certifique-se de não haver atualizações para subir
* Execute o comando abaixo
* * git pull origin main
