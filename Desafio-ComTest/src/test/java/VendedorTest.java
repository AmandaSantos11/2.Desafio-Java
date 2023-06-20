import org.example.Vendedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendedorTest {
    Vendedor vendedor = new Vendedor();

    @Test
    public void verificarSeOMetodoAdicionarClientesNaListaEstaFuncionando(){
        vendedor.adicionarVendedoresNaLista();
        List<Vendedor> listaVendedor = vendedor.getListaDeVendedores();

        assertEquals(2,listaVendedor.size());

        Vendedor vendedorUm = listaVendedor.get(0);
        assertEquals("João", vendedorUm.getNome());
        assertEquals("12345678901", vendedorUm.getCpf());
        assertEquals("joao@gmail.com", vendedorUm.getEmail());
        assertEquals("Maça", vendedorUm.getNomeDoProduto());
        assertEquals(2.50, vendedorUm.getValorUnitarioDoProduto());
        assertEquals("000", vendedorUm.getCodigoDoProduto());

        Vendedor vendedorDois = listaVendedor.get(1);
        assertEquals("Maria", vendedorDois.getNome());
        assertEquals("09876543211", vendedorDois.getCpf());
        assertEquals("maria.p@gmail.com", vendedorDois.getEmail());
        assertEquals("Chinelo", vendedorDois.getNomeDoProduto());
        assertEquals(10.2, vendedorDois.getValorUnitarioDoProduto());
        assertEquals("001", vendedorDois.getCodigoDoProduto());
    }
    @Test
    public void verificaSeOMetodoMapNomeEmailVendedorEstaFuncionando(){
        vendedor.adicionarVendedoresNaLista();

        vendedor.nomeEmailDoVendedor();

        Map<String, String> mapEmailNomeVendedor = vendedor.getMapEmailNomeVendedor();

        assertEquals(2, mapEmailNomeVendedor.size());

        assertEquals("João", mapEmailNomeVendedor.get("joao@gmail.com"));
        assertEquals("Maria", mapEmailNomeVendedor.get("maria.p@gmail.com"));
    }
    @Test
    public void verificaSeOMetodoMapEmailCpfDoVendedorEstaFuncionando(){
        vendedor.adicionarVendedoresNaLista();

        vendedor.mapEmailCpfDoVendedor();

        Map<String, String> mapEmailCpfDoVendedo = vendedor.getMapEmailCpfDoVendedor();

        assertEquals(2, mapEmailCpfDoVendedo.size());

        assertEquals("12345678901", mapEmailCpfDoVendedo.get("joao@gmail.com"));
        assertEquals("09876543211", mapEmailCpfDoVendedo.get("maria.p@gmail.com"));
    }
    @Test
    public void verificaSeOMetodoMapDoVendedorComProdutoEstaFuncionando(){
        vendedor.adicionarVendedoresNaLista();

        Map<String, List<String>> mapProdutoComVendedor = vendedor.getMapProdutoComVendedor();
        List<Vendedor> listaDeVendedores = vendedor.getListaDeVendedores();

        Vendedor vendedor1 = new Vendedor("João","12345678901","joao@gmail.com","Maça",2.50,"000");
        Vendedor vendedor2 = new Vendedor("Maria","09876543211","maria.p@gmail.com","Chinelo",10.2,"001");
        listaDeVendedores.add(vendedor1);
        listaDeVendedores.add(vendedor2);

        vendedor.mapDoVendedorComProduto();

        List<String> produtosVendedor1 = mapProdutoComVendedor.get("000");
        List<String> produtosVendedor2 = mapProdutoComVendedor.get("001");

        assertEquals(5, produtosVendedor1.size());
        assertEquals("João", produtosVendedor1.get(0));
        assertEquals("Maça", produtosVendedor1.get(1));
        assertEquals("2.5", produtosVendedor1.get(2));
        assertEquals("000", produtosVendedor1.get(3));
        assertEquals("joao@gmail.com", produtosVendedor1.get(4));

        assertEquals(5, produtosVendedor2.size());
        assertEquals("Maria", produtosVendedor2.get(0));
        assertEquals("Chinelo", produtosVendedor2.get(1));
        assertEquals("10.2", produtosVendedor2.get(2));
        assertEquals("001", produtosVendedor2.get(3));
        assertEquals("maria.p@gmail.com", produtosVendedor2.get(4));
    }
    @Test
    public void verificaSeOMetodoMostrarProdutosEstaFuncionando(){
        ByteArrayOutputStream capturaASaidaDoConsole = new ByteArrayOutputStream();

        HashMap<String, List<String>> mapProdutoComVendedor = new HashMap<>();
        List<String> listaProdutoUm = new ArrayList<>();
        listaProdutoUm.add("João");
        listaProdutoUm.add("Maça");
        listaProdutoUm.add("2.5");
        listaProdutoUm.add("000");

        List<String> listaProdutoDois = new ArrayList<>();
        listaProdutoDois.add("Maria");
        listaProdutoDois.add("Chinelo");
        listaProdutoDois.add("10.2");
        listaProdutoDois.add("001");

        mapProdutoComVendedor.put("João", listaProdutoUm);
        mapProdutoComVendedor.put("Maria", listaProdutoDois);

        System.setOut(new PrintStream(capturaASaidaDoConsole));

        vendedor.setMapProdutoComVendedor(mapProdutoComVendedor);

        vendedor.mostrarProdutos();

        String mensagemEsperada = "Vendedor: João\n" +
                "Produto: Maça\n" +
                "Valor unitário:R$2.5\n" +
                "Código:000\n" +
                "---------------------\n" +
                "Vendedor: Maria\n" +
                "Produto: Chinelo\n" +
                "Valor unitário:R$10.2\n" +
                "Código:001\n" +
                "---------------------";

        Assertions.assertEquals(mensagemEsperada.replaceAll("\\r?\\n", ""), capturaASaidaDoConsole.toString().trim().replaceAll("\\r?\\n", ""));
    }
    @Test
    public void verificaSeOMetodoMostrarVendedoresCadastradosEstaFuncionando(){
        ByteArrayOutputStream capturaASaidaDoConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturaASaidaDoConsole));

        List<Vendedor> listaDeVendedores = vendedor.getListaDeVendedores();
        Vendedor vendedorUm = new Vendedor("João","12345678901","joao@gmail.com","Maça",2.50,"000");
        Vendedor vendedorDois = new Vendedor("Maria","09876543211","maria.p@gmail.com","Chinelo",10.2,"001");
        listaDeVendedores.add(vendedorUm);
        listaDeVendedores.add(vendedorDois);

        vendedor.setListaDeVendedores(listaDeVendedores);

        vendedor.mostrarVendedoresCadastrados();

        String mensagemEsperada = "====LISTA DE VENDEDORES====\n"+
                "Nome: Maria\n" +
                "CPF: 09876543211\n" +
                "Email: maria.p@gmail.com\n" +
                "----------------------\n" +
                "Nome: João\n" +
                "CPF: 12345678901\n" +
                "Email: joao@gmail.com\n" +
                "----------------------";

        Assertions.assertEquals(mensagemEsperada.replaceAll("\\r?\\n", ""),capturaASaidaDoConsole.toString().trim().replaceAll("\\r?\\n", ""));
    }
}