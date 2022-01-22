package programa;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TesteMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> perfisUsuario = new ConcurrentHashMap<Integer, String>(3);
		
		System.out.println(perfisUsuario.put(1, "Perfil 1"));
		System.out.println(perfisUsuario.put(2, "Perfil 2"));
		System.out.println(perfisUsuario.put(3, "Perfil 3"));
		System.out.println(perfisUsuario.put(4, "Perfil 4"));
		System.out.println(perfisUsuario.put(5, "Perfil 5"));
		
		System.out.println(perfisUsuario.size());

	}

}
