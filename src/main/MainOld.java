package main;

/*
 * package programa;
 * 
 * import enums.GeneroFilme; import enums.PlanosPlataforma; import
 * filmes.CatalogoFilmes; import filmes.Filme; import filmes.GeneroAssistido;
 * import filmes.IndicacaoFilmeCatalogo; import plataforma.Plataforma; import
 * repositorios.CatalogoFilmeRepository; import usuarios.IndicacaoFilmeUsuario;
 * import usuarios.Usuario; import usuarios.UsuarioAssinaturaPlano;
 * 
 * public class ProgramaPrincipal {
 * 
 * public static void main(String[] args) {
 * 
 * // Instanciando a plataforma com o seu cat�logo de filmes Plataforma
 * plataforma = new Plataforma(CatalogoFilmeRepository.getCatalogo());
 * 
 * // Cadastrando novos filmes
 * 
 * // Cadastrando novas contas
 * 
 * // Cadastrando novos usu�rios
 * 
 * // Assistindo filme sem assinatura System.out.println(
 * "-----------------------------------------------------------");
 * System.out.println("TESTE ASSISTIR FILME SEM ASSINATURA");
 * 
 * 
 * 
 * // Assisitindo filme com assinatura por�m sem pagar a mensalidade
 * System.out.println(
 * "-----------------------------------------------------------"); System.out.
 * println("TESTE ASSISTIR FILME COM ASSINATURA MAS SEM PAGAR MENSALIDADE");
 * 
 * try { plataforma.assinarPlano(usuario1, new
 * UsuarioAssinaturaPlano(PlanosPlataforma.PREMIUM));
 * plataforma.assistirFilme(usuario1, filme1); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * // Pagando primeira mensalidade para poder assistir filmes
 * System.out.println(
 * "-----------------------------------------------------------");
 * System.out.println("TESTE ASSISTIR FILME COM ASSINATURA E ADIMPLENTE");
 * 
 * plataforma.pagarParcelaPlano(usuario1);
 * plataforma.pagarParcelaPlano(usuario6);
 * plataforma.pagarParcelaPlano(usuario7);
 * plataforma.pagarParcelaPlano(usuario8);
 * plataforma.pagarParcelaPlano(usuario9);
 * plataforma.pagarParcelaPlano(usuario10);
 * plataforma.pagarParcelaPlano(usuario11);
 * plataforma.pagarParcelaPlano(usuario12);
 * plataforma.pagarParcelaPlano(usuario13);
 * plataforma.pagarParcelaPlano(usuario14);
 * plataforma.pagarParcelaPlano(usuario15);
 * 
 * try { plataforma.assistirFilme(usuario1, filme1); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario1, filme3); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario1, filme4); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario6, filme1); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario6, filme6); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario6, filme4); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario6, filme5); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario8, filme6); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario9, filme1); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario10, filme1); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario11, filme4); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario12, filme3); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario13, filme1); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario14, filme1); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * try { plataforma.assistirFilme(usuario15, filme6); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * // Recomendando filmes para outros usu�rios System.out.println(
 * "-----------------------------------------------------------");
 * System.out.println("TESTE RECOMENDANDO FILMES PARA OUTROS USU�RIOS");
 * 
 * plataforma.indicarFilmeOutroUsuario(filme1,
 * "Filme sensacional. Voc� precisa assistir!", usuario1, usuario2);
 * plataforma.indicarFilmeOutroUsuario(filme2,
 * "Filme Top. Recomendo voc� assistir!", usuario2, usuario2);
 * plataforma.indicarFilmeOutroUsuario(filme3,
 * "Filme Incr�vel. Tenho certeza que voc� vai curtir!", usuario10, usuario2);
 * 
 * System.out.println("\nLista de recomenda��es que o usu�rio " +
 * usuario2.getNome().toUpperCase() + " recebeu: ");
 * 
 * for (IndicacaoFilmeUsuario i : usuario2.getIndicacoesRecebidas()) {
 * System.out.println("Filme Indicado: " + i.getFilme().getNome() +
 * "\nUsuario que Indicou: " + i.getUsuarioIndicou().getNome() +
 * "\nRecomenda��o: " + i.getTextoRecomendacao() + "\n"); }
 * 
 * // Curtindo/Descurtindo filmes System.out.println(
 * "-----------------------------------------------------------");
 * System.out.println("TESTE CURTIDAS/DESCURTIDAS DOS FILMES\n");
 * 
 * try { plataforma.curtirFilme(usuario1, filme1);
 * plataforma.curtirFilme(usuario1, filme2); plataforma.curtirFilme(usuario1,
 * filme1); // N�o ser� contabilizado, pois usu�rio j� curtiu esse filme
 * plataforma.descurtirFilme(usuario1, filme2); //
 * 
 * plataforma.curtirFilme(usuario6, filme1);
 * 
 * plataforma.curtirFilme(usuario7, filme2);
 * 
 * plataforma.curtirFilme(usuario8, filme3);
 * 
 * plataforma.curtirFilme(usuario9, filme3);
 * 
 * plataforma.curtirFilme(usuario10, filme4);
 * 
 * plataforma.curtirFilme(usuario11, filme4);
 * 
 * plataforma.curtirFilme(usuario12, filme4);
 * 
 * plataforma.curtirFilme(usuario13, filme5);
 * 
 * plataforma.curtirFilme(usuario14, filme5);
 * 
 * plataforma.curtirFilme(usuario15, filme6); } catch (Exception e) {
 * e.getMessage(); e.printStackTrace(); }
 * 
 * for (Filme i : plataforma.getCatalogo().getFilmes()) {
 * System.out.println(i.getNome().toUpperCase() + ": " + i.getQtdCurtidas() +
 * " curtida(s)"); }
 * 
 * // Indicando filmes novos para o cat�logo da platagorma de filmes
 * System.out.println(
 * "-----------------------------------------------------------");
 * System.out.println("TESTE SUGEST�O DE FILMES PARA O CATALOGO DE FILMES\n");
 * 
 * try { plataforma.indicarFilmeCatalogo("Harry Potter e a Pedra Filosofal",
 * usuario1); plataforma.indicarFilmeCatalogo("T� Dando Onda", usuario2);
 * plataforma.indicarFilmeCatalogo("Viva - A vida � uma festa", usuario1); }
 * catch (Exception e) { e.getMessage(); e.printStackTrace(); }
 * 
 * for (IndicacaoFilmeCatalogo i :
 * plataforma.getCatalogo().getIndicacoesNovosFilmesUsuario()) {
 * System.out.println("Filme Indicado: " + i.getFilme() + "\nUsuario Indicou: "
 * + i.getUsuarioIndicou().getNome() + "\nData Indicacao: " +
 * i.getDataIndicacao() + "\nData �ltima Indica��o: " +
 * i.getDataUltimaIndicacao() + "\nQuantidade de Indica��es: " +
 * i.getQtdIndicacaoUsuario() + "\n"); }
 * 
 * // Lista g�neros assistidos da plataforma e g�neros assistidos pelo usu�rio
 * System.out.println(
 * "\n-----------------------------------------------------------");
 * System.out.println("TESTE LISTANDO GENEROS ASSISTIDO DO CAT�LOGO DE FILMES\n"
 * ); for (GeneroAssistido i : plataforma.getGenerosAssistidosPlataforma()) {
 * System.out.println(i.getGeneroAssistido().name() + " - " +
 * i.getQtdAssistido()); }
 * 
 * System.out .println("\nTESTE LISTANDO GENEROS ASSISTIDOS PELO USU�RIO " +
 * usuario1.getNome().toUpperCase() + "\n"); for (GeneroAssistido i :
 * usuario1.getGenerosAssistidosUsuario()) {
 * System.out.println(i.getGeneroAssistido().name() + " - " +
 * i.getQtdAssistido()); }
 * 
 * System.out .println("\nTESTE LISTANDO GENEROS ASSISTIDOS PELO USU�RIO " +
 * usuario6.getNome().toUpperCase() + "\n"); for (GeneroAssistido i :
 * usuario6.getGenerosAssistidosUsuario()) {
 * System.out.println(i.getGeneroAssistido().name() + " - " +
 * i.getQtdAssistido()); }
 * 
 * // Imprime g�nero mais assitido da plataforma e do usu�rio
 * System.out.println(
 * "\n-----------------------------------------------------------");
 * System.out.print("G�nero mais assistido do cat�logo de filmes: ");
 * System.out.print(plataforma.getGeneroMaisAssistido());
 * 
 * System.out.print("\n\nG�nero mais assistido do usu�rio  " +
 * usuario1.getNome().toUpperCase() + ": ");
 * System.out.print(usuario1.getGeneroMaisAssistido());
 * 
 * System.out.print("\n\nG�nero mais assistido do usu�rio  " +
 * usuario6.getNome().toUpperCase() + ": ");
 * System.out.print(usuario6.getGeneroMaisAssistido());
 * 
 * }
 * 
 * }
 */