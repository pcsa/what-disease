# Primeira execução

### Na classe br.com.imd.whatDisease.util.HibernateUtil

* Na linha 12 modificar `configuracao.configure("hibernate_postgres.cfg.xml");` para seu respectivo banco, opções são:

> `hibernate_mysql.cfg.xml`
ou
> `hibernate_mysql.cfg.xml`

### No diretorio src/main/resources/hibernate_XXXXX.cfg.xml:

1. troque o preenchimento da tag <property name="connection.username">username</property> para o respectivo username do seu banco de dados

2. troque o preenchimento da tag <property name="connection.password">password</property> para a respectiva password do seu banco de dados

3. No preencimento da tag <property name="hbm2ddl.auto">create</property> certifique de que esta escrito create, para criar as tabelas do banco.

#### Popular banco:

* Para agilizar os testes pode-se rodar como standalone o arquivo .java, `br.com.imd.whatDisease.util.PovoaDB`

# Importante para o eclipse IDE

1. Abrir a aba Help > Install new software.
2. Colar este link `https://projectlombok.org/p2` e installar o plugin do lombok.

> Por alguma razão é necessario além da dependência do maven instalar este plugin no eclipse.
