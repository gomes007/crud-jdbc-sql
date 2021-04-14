package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserfone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initiBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		
		userposjava.setNome("1111");
		userposjava.setEmail("111@gmail.com");
		
		userPosDAO.salvar(userposjava);
				
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava.getNome());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava userposjava = dao.buscar(4L);
			
			System.out.println(userposjava);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	@Test
	public void initAtualizar () {
		
		try {
			UserPosDAO dao = new UserPosDAO();
			Userposjava objetoBanco = dao.buscar(2L);
			
			objetoBanco.setNome("Carlos");
			
			dao.atualizar(objetoBanco);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(9L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("31-1111");
		telefone.setTipo("casa");
		telefone.setUsuario(10L);	
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvaTelefone(telefone);		
	}
	
	
	@Test
	public void testeListaTelefoneUser() {
	
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserfone> userfone = dao.listaUserFone(10L);
		
		for (BeanUserfone beanUserfone : userfone) {
			System.out.println(beanUserfone);
		}
			
	}
	

	@Test
	public void testeDeleteUserFone() {
		
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(11L);
		
		
		
	}
	
	
	
	
}
