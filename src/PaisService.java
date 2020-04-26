public class PaisService {

	PaisDAO dao = new PaisDAO();

	public int criar (Pais pais) {
		return dao.incluir(pais);
	}
	
	public void atualizar(Pais pais) {
		dao.atualizar(pais);
	}
	
	public Pais consultar(int id) {
		Pais pais = dao.carregar(id);
		return pais;
	}
		public void excluir(Pais pais) {
			dao.excluir(pais);
		}
		
	}

