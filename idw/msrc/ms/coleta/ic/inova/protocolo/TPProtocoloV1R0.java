package ms.coleta.ic.inova.protocolo;

public class TPProtocoloV1R0 {
    public short endereco_fonte;
    public short endereco_destino;
    public short tamanho_dado;
    public byte[] dados;

    //
    public boolean Recebeu;

    // configuracoes
    public short cfg_meu_endereco;
	public short is_pct_dnc;

    // controles
    public boolean ctrl_start;
    public boolean ctrl_mark;
    public short ctrl_indice_buffer;
    public short ctrl_indice_cabecalho;
    public short ctrl_cs;
    public short cs;
}
