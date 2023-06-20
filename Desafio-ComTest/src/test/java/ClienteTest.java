import org.example.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {
    Cliente cliente = new Cliente();

    @Test
    public void verificarSeOMetodoAdicionarClientesNaListaEstaFuncionando(){
        cliente.adicionarClientesNaLista();
        List<Cliente> listaClientes = cliente.getListaDeClientes();

        assertEquals(2,listaClientes.size());

        Cliente clienteUm = listaClientes.get(0);
        assertEquals("Lola", clienteUm.getNome());
        assertEquals("12309845671", clienteUm.getCpf());
        assertEquals("lola.ortega@gmail.com", clienteUm.getEmail());

        Cliente clienteDois = listaClientes.get(1);
        assertEquals("Matheus", clienteDois.getNome());
        assertEquals("78907213451", clienteDois.getCpf());
        assertEquals("math32@gmail.com", clienteDois.getEmail());
    }
    @Test
    public void verificaSeOMetodoMapCpfEmailDoClienteEstaFuncionando(){
        cliente.adicionarClientesNaLista();

        cliente.mapCpfEmailDoCliente();

        Map<String, String> mapCpfEmailDoCliente = cliente.getMapCpfEmailDoCliente();

        assertEquals(2, mapCpfEmailDoCliente.size());

        assertEquals("lola.ortega@gmail.com", mapCpfEmailDoCliente.get("12309845671"));
        assertEquals("math32@gmail.com", mapCpfEmailDoCliente.get("78907213451"));
    }
    @Test
    public void verificaSeOMetodoMapCpfNomeClienteEstaFuncionando(){
        cliente.adicionarClientesNaLista();

        cliente.cpfNomeDoCliente();

        Map<String, String> cpfNomeDoCliente = cliente.getMapCpfNomeCliente();

        assertEquals(2, cpfNomeDoCliente.size());

        assertEquals("Lola", cpfNomeDoCliente.get("12309845671"));
        assertEquals("Matheus", cpfNomeDoCliente.get("78907213451"));
    }
    @Test
    public void verificaSeOMetodoMostrarClientesCadastradosEstaFuncionando(){
        ByteArrayOutputStream capturaASaidaDoConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturaASaidaDoConsole));

        List<Cliente> listaDeClientes = cliente.getListaDeClientes();
        Cliente clienteUm = new Cliente("Lola","12309845671","lola.ortega@gmail.com");
        Cliente clienteDois = new Cliente("Matheus","78907213451","math32@gmail.com");
        listaDeClientes.add(clienteUm);
        listaDeClientes.add(clienteDois);

        cliente.setListaDeClientes(listaDeClientes);

        cliente.mostrarClientesCadastrados();

        String mensagemEsperada = "====LISTA DE CLIENTES====\n"+
                "Cliente: Lola\n" +
                "CPF: 12309845671\n" +
                "Email: lola.ortega@gmail.com\n" +
                "----------------------\n" +
                "Cliente: Matheus\n" +
                "CPF: 78907213451\n" +
                "Email: math32@gmail.com\n" +
                "----------------------";

        Assertions.assertEquals(mensagemEsperada.replaceAll("\\r?\\n", ""),capturaASaidaDoConsole.toString().trim().replaceAll("\\r?\\n", ""));
    }
}
