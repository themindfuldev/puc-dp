namespace VendasCliente
{
    partial class RealizarPedido
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.comboBox_Produto = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.BotaoRealizarPedido = new System.Windows.Forms.Button();
            this.TextBoxQuantidade = new System.Windows.Forms.MaskedTextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // comboBox_Produto
            // 
            this.comboBox_Produto.FormattingEnabled = true;
            this.comboBox_Produto.Items.AddRange(new object[] {
            ""});
            this.comboBox_Produto.Location = new System.Drawing.Point(12, 24);
            this.comboBox_Produto.Name = "comboBox_Produto";
            this.comboBox_Produto.Size = new System.Drawing.Size(174, 21);
            this.comboBox_Produto.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 7);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(49, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Produtos";
            // 
            // BotaoRealizarPedido
            // 
            this.BotaoRealizarPedido.Location = new System.Drawing.Point(339, 24);
            this.BotaoRealizarPedido.Name = "BotaoRealizarPedido";
            this.BotaoRealizarPedido.Size = new System.Drawing.Size(102, 23);
            this.BotaoRealizarPedido.TabIndex = 2;
            this.BotaoRealizarPedido.Text = "Comprar";
            this.BotaoRealizarPedido.UseVisualStyleBackColor = true;
            this.BotaoRealizarPedido.Click += new System.EventHandler(this.BotaoRealizarPedido_Click);
            // 
            // TextBoxQuantidade
            // 
            this.TextBoxQuantidade.Location = new System.Drawing.Point(237, 24);
            this.TextBoxQuantidade.Mask = "###";
            this.TextBoxQuantidade.Name = "TextBoxQuantidade";
            this.TextBoxQuantidade.Size = new System.Drawing.Size(59, 20);
            this.TextBoxQuantidade.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(237, 8);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(62, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Quantidade";
            // 
            // RealizarPedido
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.GradientInactiveCaption;
            this.ClientSize = new System.Drawing.Size(458, 65);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.TextBoxQuantidade);
            this.Controls.Add(this.BotaoRealizarPedido);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboBox_Produto);
            this.ForeColor = System.Drawing.Color.Black;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "RealizarPedido";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Sistema de Pedidos";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox comboBox_Produto;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button BotaoRealizarPedido;
        private System.Windows.Forms.MaskedTextBox TextBoxQuantidade;
        private System.Windows.Forms.Label label2;
    }
}

