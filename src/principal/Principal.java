package principal;

import conexao.Conexao;
import dao.DaoLivro;
import entities.Livro;

public class Principal {

	public static void main(String[] args) {
		MetodosCRUD metod= new MetodosCRUD();
		//metod.mostrarUm();
		//metod.mostrarTodos();
		metod.cadastrar();
		//metod.modificar();
		
				//cadastrar();
	//mostrarTodos();
		//mostrarUm();
	//modificar();
	//apagar();
	//mostrarTodos();
	
	}
	
//	static void cadastrar() {
//		Livro livro1= new Livro("The Secret", "Rhonda Byrne", 2007, "Ediouro", 1);
//		DaoLivro dl= new DaoLivro();
//		if(dl.salvar(livro1)) {
//			System.out.println("Livro cadastrado com sucesso");
//		}
//		else {
//			System.out.println("Erro ao cadastrar");
//	}
//		}
	
//	static void mostrarUm() {
//		DaoLivro dl= new DaoLivro();
//		System.out.println(dl.consultar(2));
//	}
	
//	static void mostrarTodos() {
//		DaoLivro dl= new DaoLivro();
//		System.out.println(dl.consultar());
//	}
	
	static void modificar() {
		DaoLivro dl= new DaoLivro();
		Livro livro= dl.consultar(1);
		livro.setVolume(2);
		dl.alterar(livro);
			System.out.println(dl.consultar(1));
	}
	static void apagar() {
		DaoLivro dl= new DaoLivro();
		dl.excluir(2);
	}

}
