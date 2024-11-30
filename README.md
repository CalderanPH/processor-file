## Conteúdos

Challange desenvolvido para processar arquivos.

> Desenvolvido por Paulo Calderan.

---

### Stack

| Tecnologia  | Versão |
|-------------|--------|
| Java        | 21     |
| SpringBoot  | 3.4.0  |


---

## Rodando o Projeto

1. **Clone esse repositório:**

    ```bash
    git clone https://github.com/CalderanPH/processor-file.git
    ```

2. **Instale o Docker em seu computador:**
   - [Instruções para Windows](https://docs.docker.com/desktop/install/windows-install/)

3. **Inicie a aplicação:**
   - Instale o SDK 21 para Java: [Download aqui](https://www.oracle.com/br/java/technologies/downloads/)
   - No terminal:
     ```bash
     docker compose up
     ```
     Posteriormente, execute a classe: `RankRightApplication`

4. **Gerando os arquivos para testar a aplicacao**
   - Formato CSV:
       ```bash
      name,email
      John Doe,john.doe@example.com
      Jane Smith,jane.smith@example.com
      Robert Johnson,robert.johnson@example.com
      Emily Davis,emily.davis@example.com
      Michael Brown,michael.brown@example.com
     ```
    - Formato XML:
         ```bash
        <users>
      <user>
          <name>John Doe</name>
          <email>john.doe@example.com</email>
      </user>
      <user>
          <name>Jane Smith</name>
          <email>jane.smith@example.com</email>
      </user>
      <user>
          <name>Robert Johnson</name>
          <email>robert.johnson@example.com</email>
      </user>
      <user>
          <name>Emily Davis</name>
          <email>emily.davis@example.com</email>
      </user>
      <user>
          <name>Michael Brown</name>
          <email>michael.brown@example.com</email>
      </user>
      </users>
       ```
    - Formato JSON:
        ```bash
        [
      {
          "name": "John Doe",
          "email": "john.doe@example.com"
      },
      {
          "name": "Jane Smith",
          "email": "jane.smith@example.com"
      },
      {
          "name": "Robert Johnson",
          "email": "robert.johnson@example.com"
      },
      {
          "name": "Emily Davis",
          "email": "emily.davis@example.com"
      },
      {
          "name": "Michael Brown",
          "email": "michael.brown@example.com"
      }
      ]
       ```

### Documentação

O projeto utiliza o swagger para documentar as APIs. Para acessar a documentação, acessar:

    http://localhost:8080/swagger-ui.html
