import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class PaisTest {
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("Alemanha");
		pais.setPopulacao(Long.valueOf("2345"));
		pais.setArea(Double.valueOf(234.0));
		copia = new Pais();
		copia.setId(id);
		copia.setNome("Brasil");
		copia.setPopulacao(Long.valueOf("1234"));
		copia.setArea(Double.valueOf(5678));
		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	@Test
	public void testCriar() {
		System.out.println("criar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}
	@Test
	public void testCarregar() {
		System.out.println("carregar");
		Pais fixture = new Pais();
		fixture.setId(1);
		fixture.setNome("Portugal");
		fixture.setPopulacao(Long.valueOf("123456"));
		fixture.setArea(Double.valueOf(987654));
		PaisService novoService = new PaisService();
		Pais novo = novoService.consultar(1);
		assertEquals("testa inclusao", novo, fixture);
	}
	@Test
	public void testAtualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(Long.valueOf("123456"));
		copia.setArea(Double.valueOf(987654));
		paisService.atualizar(pais);
		pais = paisService.consultar(pais.getId());
		assertEquals("testa atualizacao", pais, copia);
	}
	@Test
	public void testExcluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao((Long) null);
		copia.setArea((Double) null);
		paisService.excluir(pais);
		pais = paisService.consultar(id);
		assertEquals("testa exclusao", pais, copia);
	}
}