using System;
using System.Windows.Forms;
using Entidade.Entidades;

namespace VendasCliente
{
    public partial class RealizarPedido : Form
    {

        public RealizarPedido()
        {
            InitializeComponent();
        }

        public class KeyValue
        {
            private string key;
            private string value;
        }

        #region Eventos
        private void Form1_Load(object sender, EventArgs e)
        {
            CarregarTela();
        }
        #endregion
        #region Métodos
        private void CarregarTela()
        {
            CarregarComboBox();
        }
        private void CarregarComboBox()
        {
            var listaProdutos = Servicos.Servicos.ObterProdutos();
            comboBox_Produto.DataSource = listaProdutos;
            comboBox_Produto.DisplayMember = "Nome";
            comboBox_Produto.ValueMember = "IdProduto";
        }

        #endregion

        private void BotaoRealizarPedido_Click(object sender, EventArgs e)
        {

            if(Validar())
            {

                RegistrarPedido();
            }
        }

        private bool Validar()
        {
            if(string.IsNullOrEmpty(TextBoxQuantidade.Text))
            {
                MessageBox.Show(@"Você deve definir a quantidade de produtos");
                return false;
            }

            if (comboBox_Produto.SelectedValue == null)
            {
                MessageBox.Show(@"Você deve selecionar um produto");
                return false;
            }
            return true;
        }

        private void RegistrarPedido()
        {
            try
            {
                var servicos = new Servicos.Servicos();
                var retorno = servicos.ProcessarPedido(Convert.ToInt32(comboBox_Produto.SelectedValue), Convert.ToInt32(TextBoxQuantidade.Text));
                
                if (retorno.FgProcessado)
                {
                    CarregarConfirmacao(retorno);

                }
                else
                {
                    CarregarErro(retorno);
                }
            }
            catch (Exception e)
            {

                MessageBox.Show(string.Format("Ocorreu um Erro ao processar o pedido: {0}",e.Message));
            }

        }

        public static void CarregarErro(Retorno retorno)
        {

            MessageBox.Show(string.Format("Erro ao processar o pedido {0}", retorno.MensagemRetorno));
           
        }

        private static void CarregarConfirmacao(Retorno retorno)
        {

            MessageBox.Show(string.Format("Pedido processado com sucesso. \r\n Número do pedido: {1} \r\n Valor total de R${2} \r\n Data estimada para entrega: {0} ", retorno.DataEntrega.ToShortDateString(), retorno.IdPedido, retorno.ValorTotal));
        }
    }
}
