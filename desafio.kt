class Usuario(val name: String, val email: String) {
     // Additional properties and methods can be added here
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
	
    val inscritos = mutableListOf<Usuario>()
    
    /**
     * Enrolls a user in the formation.
     * @param usuario The user to be enrolled.
     */
    
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        if (!inscritos.contains(usuario)) { // if usuario no enrolls, usuario accept
            inscritos.add(usuario)
            println("${usuario.name} foi matriculado na formação $nome.")
        } else {
            println("${usuario.name} já está matriculado na formação $nome.")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Alice", "alice@example.com")
    val usuario2 = Usuario("Bob", "bob@example.com")
    val usuario3 = Usuario("Alisson", "Alisson@example.com")
    
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Algoritmos Avançados", 180)
    val conteudo3 = ConteudoEducacional("Paradigmas de programação", 120) 
    val conteudo4 = ConteudoEducacional("Fundamentos administrativos",80)
    
    val formacao = Formacao("Ciência da Computação", listOf(conteudo1, conteudo2, conteudo3))
    val formacao2 = Formacao("Sistemas de Informação", listOf(conteudo1, conteudo2, conteudo4))
    
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // Trying to enroll the same user again
    formacao2.matricular(usuario3)
    
    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos.joinToString(", ") { it.name }}")
    println("Inscritos na formação ${formacao2.nome}: ${formacao2.inscritos.joinToString(", ") { it.name }}")
}