using System.Collections.Generic;
using Entidade.Entidades;


namespace Servicos
{
    public class Servicos
    {
        public static IList<Produto> ObterProdutos()
        {
            var listaProduto = new List<Produto>
                                   {
                                       new Produto {Nome = "Produto 1", IdProduto = 1111},
                                       new Produto {Nome = "Produto 2", IdProduto = 2222},
                                       new Produto {Nome = "Produto 3", IdProduto = 3333},
                                       new Produto {Nome = "Produto 4", IdProduto = 4444},
                                       new Produto {Nome = "Produto 5", IdProduto = 5555},
                                       new Produto {Nome = "Produto 6", IdProduto = 6666}
                                   };
            return listaProduto;
        }

        public Retorno ProcessarPedido(int idProduto, int quantidade)
        {
            var servico = new ProcessarPedidoService.ProcessarPedido();
            var retorno = servico.RegistrarVenda(idProduto, quantidade);
            return new Retorno
                       {
                           DataEntrega = retorno.DataEntrega,
                           FgProcessado = retorno.FgProcessado,
                           IdPedido = retorno.IdPedido,
                           MensagemRetorno = retorno.MensagemRetorno,
                           ValorTotal = retorno.ValorTotal
                       };
        }
    }


}
