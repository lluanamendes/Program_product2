<h1>Cadastro de Produtos - Java & JavaFX</h1>
<p>Este projeto é um sistema simples para cadastro de produtos utilizando <strong>Java</strong> e <strong>JavaFX</strong> para interface gráfica.</p>
    
  <h2>Descrição do Projeto</h2>
    <p>O sistema permite cadastrar três tipos de produtos:</p>
    <ul>
        <li><strong>Comum</strong>: Apenas nome e preço.</li>
        <li><strong>Usado</strong>: Nome, preço e data de fabricação.</li>
        <li><strong>Importado</strong>: Nome, preço e taxa alfandegária.</li>
    </ul>
    <p>Após a inserção, os produtos são exibidos com etiquetas de preço formatadas corretamente.</p>
    
  <h2>Estrutura do Código</h2>
    <ul>
        <li><strong>main/Main.java</strong>: Classe principal que inicia a aplicação.</li>
        <li><strong>ui/ProductUI.java</strong>: Classe responsável pela interface gráfica com JavaFX.</li>
        <li><strong>entities/Product.java</strong>: Classe base para produtos.</li>
        <li><strong>entities/UsedProduct.java</strong>: Extende <code>Product</code>, incluindo data de fabricação.</li>
        <li><strong>entities/ImportedProduct.java</strong>: Extende <code>Product</code>, incluindo taxa alfandegária.</li>
    </ul>
    
  <h2>Como Executar</h2>
    <ol>
        <li>Certifique-se de ter o JavaFX configurado corretamente no seu ambiente.</li>
        <li>Compile e execute a classe <code>Main</code>.</li>
        <li>Interaja com a interface para adicionar produtos.</li>
    </ol>
        <h2>Requisitos</h2>
    <ul>
        <li>Java 11 ou superior</li>
        <li>JavaFX configurado no projeto</li>
        <li>IDE como Eclipse ou IntelliJ</li>
    </ul>
    
  <h2>Autor</h2>
  <p>Desenvolvido como um projeto de aprendizado para manipulação de classes em Java e criação de interfaces gráficas. Curso do Neli Alves.</p>
