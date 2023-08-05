programa {
  funcao inicio() {
    cadeia cadastro_cliente[3];
    cadeia destino_viagem[3];
    inteiro i,c;
    cadeia destino, opcao, nome;

    para(i=0;i<3;i++){
      escreva("Nome do cliente: ")
      leia(cadastro_cliente[i])

      escreva("Destino da viajem: ")
      leia(destino_viagem[i])

      escreva('\n')
    }

    enquanto(opcao != 4){
      menu()
      escreva('\n')

      escreva("Deseja fazer uma consulta?",'\t')
      leia(opcao)

      se(opcao == 1){
        escreva("Digite o nome do cliente: ", '\t')
        leia(nome)
        para(i=0;i<3;i++){
          se(nome==cadastro_cliente[i]){
            escreva('-',cadastro_cliente[i], ':', '\t',destino_viagem[i],'\n')
          }
        }
      }
      senao se (opcao == 2){
        escreva("Digite o destino: ",'\t')
        leia(destino)
        para(i=0;i<3;i++){
          se(destino==destino_viagem[i]){
            escreva('-',cadastro_cliente[i],'\n')
          }
        }
      }
      senao se (opcao == 3){
        para(i=0;i<3;i++){
          escreva('-',cadastro_cliente[i], ':', '\t',destino_viagem[i],'\n')
        }
      }
      senao{
        escreva("Volte sempre!")
      }
      escreva('\n')
    }
  funcao menu(){
    escreva("1.Consultar por nome do cliente",'\n', "2.Consultar por destino",'\n',"3.Mostrar todos os clientes",'\n',"4.Sair",'\n')
  }  
  }
}
