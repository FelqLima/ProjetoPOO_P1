package modelo;

public enum EnumMeioDePagamento {
	
	   PIX("Pix"),
	   BOLETO("Boleto"),
	   CARTAO_CREDITO("Cartão de crédito"),
	   CARTAO_DEBITO("Cartão de débito");

	   private final String descricao;

	   EnumMeioDePagamento(String descricao) {
	      this.descricao = descricao;
	   }

	   public String getDescricao() {
	      return descricao;
	   }

}
