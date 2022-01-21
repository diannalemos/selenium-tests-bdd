package br.com.dslemos.steps;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class InserirContasSteps {
    private WebDriver driver;

    @Given("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
    }
    @When("informo o usuário \"([^\"]*)\"$")
    public void informoOUsuárioUsuario(String user) {
       driver.findElement(By.id("email")).sendKeys(user);
    }
    @When("a senha \"([^\"]*)\"$")
    public void aSenhaSenha(String pwd) {
        driver.findElement(By.id("senha")).sendKeys(pwd);
    }
    @When("seleciono entrar")
    public void selecionoEntrar() {
        driver.findElement(By.tagName("button")).click();
    }
    @Then("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, Diana!", texto);
    }
    @When("seleciono Contas")
    public void selecionoContas() {
        driver.findElement(By.linkText("Contas")).click();
    }
    @When("seleciono Adicionar")
    public void selecionoAdicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }
    @When("informo a conta \"([^\"]*)\"$")
    public void informoAConta(String conta) {
        driver.findElement(By.id("nome")).sendKeys(conta);
    }
    @When("seleciono Salvar")
    public void selecionoSalvar() {
        driver.findElement(By.tagName("button")).click();
    }
    @Then("a conta é inserida com sucesso")
    public void aContaÉInseridaComSucesso() throws InterruptedException {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", texto);
    }
    @Then("sou notificado que o nome da conta é obrigatório")
    public void souNotificadoQueONomeDaContaÉObrigatório() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Informe o nome da conta", texto);
    }
    @Then("sou notificado que já existe uma conta com esse nome")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Já existe uma conta com esse nome!", texto);
    }

   @After
   public void fecharBrowser() {
        driver.quit();
   }

}

