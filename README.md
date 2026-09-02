# 💈 Barber Place - Marketplace de Barbearias

Uma plataforma inovadora que conecta clientes com profissionais de barbearia (barbeiros, cabeleireiros) em domicílio, funcionando como um marketplace com modelo de comissão.

**Status do Projeto:** 🟡 Em Desenvolvimento (35% - Sprint 1)

---

## 📋 Visão Geral

Barber Place é um marketplace B2C/B2B que permite:

- **Clientes:** Agendar serviços de barbearia com profissionais verificados
- **Profissionais:** Oferecer serviços (corte, barba, coloração, etc) presencialmente ou a domicílio
- **Plataforma:** Gerenciar agendamentos, pagamentos e comissões de forma automática

### 🎯 Modelo de Negócio

- **Comissão:** 15% por agendamento realizado
- **Exemplo:** Cliente paga R$100 → Profissional recebe R$85 → Plataforma recebe R$15
- **Pagamento:** Via AbacatePay (fintech brasileira)

---

## 🏗️ Arquitetura

### Clean/Hexagonal Architecture

```
┌─────────────────────────────────────────────────┐
│         adapter.in (Controllers)                 │
│   [RegisterCustomerController]                   │
└──────────────────┬──────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────┐
│      application (Business Logic)                 │
│ [RegisterCustomer, UpdateCustomer, etc]         │
└──────────────────┬──────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────┐
│    adapter.out (Repositories, Mappers)           │
│  [RegisterClientJpaRepository, ClientMapper]    │
└──────────────────┬──────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────┐
│         Shared (DTOs, Enums, Exceptions)         │
│    [ClientDTO, ErrorDTO, ControllerHandler]    │
└─────────────────────────────────────────────────┘
```

### Módulos (Microserviços)

- **cadastro_cliente** - Registro e gerenciamento de clientes (95% pronto)
- **cadastro_barbeiro** - Registro e gerenciamento de profissionais (95% pronto)
- **agendamento_api** - Agendamentos e calendário (0% - próximo)

---

## 💻 Stack Técnico

### Backend
| Tecnologia | Versão | Propósito |
|-----------|--------|----------|
| **Java** | 21 | Linguagem de programação |
| **Spring Boot** | 4.1.0 | Framework web |
| **Spring Data JPA** | - | ORM/Persistência |
| **Spring Security** | - | Autenticação (preparado) |
| **MySQL** | 8.0+ | Banco de dados |
| **MapStruct** | 1.6.3 | Mapeamento de objetos |
| **Lombok** | - | Redução de boilerplate |
| **Maven** | - | Build tool |

### Frontend (Próximo Sprint)
| Tecnologia | Versão | Propósito |
|-----------|--------|----------|
| **React** | 18+ | UI library |
| **Next.js** | 14+ | Framework full-stack |
| **TypeScript** | 5+ | Type safety |
| **Tailwind CSS** | 3+ | Styling |
| **Redux Toolkit** | - | State management |
| **Axios** | - | HTTP client |

### Pagamento
| Tecnologia | Propósito |
|-----------|----------|
| **Em definição** | Processamento de pagamentos |

### Deploy
| Tecnologia | Propósito |
|-----------|----------|
| **Docker** | Containerização |
| **AWS RDS** | Banco de dados produção |
| **AWS ECR** | Container registry |
| **ECS/EKS** | Orquestração de containers |

---

## 🚀 Getting Started

### Pré-requisitos

```bash
# Verificar versões
java -version          # Java 21+
mvn -version          # Maven 3.8+
mysql --version       # MySQL 8.0+
node -v              # Node 18+ (para frontend)
```

### 1. Clone o Repositório

```bash
git clone https://github.com/01122025/ms-app-barber-plataform.git
cd ms-app-barber-plataform
```

### 2. Configurar Banco de Dados

```bash
# Criar banco de dados
mysql -u root -p
CREATE DATABASE service_orchestrator;
CREATE USER 'barber'@'localhost' IDENTIFIED BY 'barber123';
GRANT ALL PRIVILEGES ON service_orchestrator.* TO 'barber'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```

### 3. Configurar Environment Variables

```bash
# Copiar arquivo de exemplo
cp .env.example .env

# Editar com suas credenciais
# cadastro_cliente/src/main/resources/application.yaml
spring:
  datasource:
    url: jdbc:mysql://localhost/service_orchestrator
    username: barber
    password: barber123
  jpa:
    hibernate:
      ddl-auto: update
```

### 4. Instalar Dependências e Rodar Backend

```bash
# Navegar para módulo cliente
cd cadastro_cliente

# Instalar dependências Maven
mvn clean install

# Rodar a aplicação
mvn spring-boot:run

# Aplicação rodará em: http://localhost:8080
```

### 5. Rodar Frontend (Próxima Sprint)

```bash
# Instalar dependências
npm install

# Rodar dev server
npm run dev

# Frontend em: http://localhost:3000
```

---

## 📚 Estrutura de Pastas

```
ms-app-barber-plataform/
├── cadastro_cliente/                    # Módulo de clientes
│   ├── src/main/java/br/com/api/salaohub/
│   │   ├── adapter/
│   │   │   ├── in/                      # Controllers
│   │   │   │   └── RegisterCustomerController.java
│   │   │   └── out/                     # Repositories, Mappers
│   │   │       ├── entity/
│   │   │       ├── jpaRepository/
│   │   │       └── mapper/
│   │   ├── application/                 # Use Cases / Business Logic
│   │   │   ├── RegisterCustomer.java
│   │   │   ├── UpdateCustomer.java
│   │   │   └── DeleteCustomer.java
│   │   ├── shared/                      # Shared code
│   │   │   ├── dto/                     # Data Transfer Objects
│   │   │   ├── enums/
│   │   │   └── exception/               # Global exception handling
│   │   └── boot/                        # Application bootstrap
│   │       ├── config/
│   │       └── security/
│   ├── src/main/resources/
│   │   └── application.yaml
│   ├── pom.xml
│   └── README.md
│
├── cadastro_barbeiro/                   # Módulo de profissionais
│   └── [Similar structure]
│
├── agendamento_api/                     # Módulo de agendamentos (vazio)
│   └── [Em desenvolvimento]
│
└── README.md                            # Este arquivo
```

---

## 🔌 Endpoints Disponíveis

### Clientes

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| POST | `/customers/registerCustomer` | Registrar novo cliente | ✅ Pronto |
| PUT | `/customers/updateClient` | Atualizar dados do cliente | ✅ Pronto |
| DELETE | `/customers/deleteClient` | Deletar cliente | ✅ Pronto |
| GET | `/customers` | Listar clientes (paginado) | ⏳ T2.1 |
| GET | `/customers/{id}` | Buscar cliente por ID | ⏳ T2.1 |
| GET | `/customers/search` | Buscar clientes | ⏳ T2.1 |

### Profissionais

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| POST | `/professionals/registerProfessional` | Registrar profissional | ✅ Pronto |
| PUT | `/professionals/updateProfessional` | Atualizar profissional | ✅ Pronto |
| DELETE | `/professionals/deleteProfessional` | Deletar profissional | ✅ Pronto |
| GET | `/professionals` | Listar profissionais | ⏳ T2.2 |
| GET | `/professionals/{id}` | Buscar profissional | ⏳ T2.2 |
| GET | `/professionals/search` | Buscar por especialidade | ⏳ T2.2 |

### Agendamentos (Em desenvolvimento)

```
⏳ POST   /appointments              - Criar agendamento
⏳ GET    /appointments/{id}         - Buscar agendamento
⏳ GET    /appointments/professional/{id} - Agenda do profissional
⏳ PUT    /appointments/{id}/confirm - Confirmar agendamento
⏳ DELETE /appointments/{id}         - Cancelar agendamento
```

### Autenticação (Sprint 1)

```
⏳ POST /auth/login   - Login
⏳ POST /auth/signup  - Registrar
⏳ POST /auth/refresh - Renovar token JWT
```

---

## 📊 Progresso do Projeto

### Fase 1: Backend (35% Concluído)

#### ✅ Completado
- [x] Arquitetura Clean/Hexagonal
- [x] Módulo Cadastro Cliente (CRUD básico)
- [x] Módulo Cadastro Profissional (CRUD básico)
- [x] MapStruct para mapeamento
- [x] Exception handling globalizado
- [x] Spring Security setup (básico)

#### 🟡 Em Progresso (Sprint 1)
- [ ] Corrigir unique constraints incorretos
- [ ] Adicionar campos de auditoria (createdAt, updatedAt)
- [ ] Implementar soft delete
- [ ] JWT Authentication completo

#### ⏳ A Fazer
- [ ] GET endpoints com paginação (T2.1, T2.2)
- [ ] Estender campos de domínio (foto, bio, especialidade)
- [ ] Módulo de agendamentos (T3.1-T3.5)
- [ ] Validações customizadas
- [ ] Testes de cobertura 70%

### Fase 2: Frontend (0% - Sprint 7+)

- [ ] Setup Next.js + React
- [ ] Telas de autenticação
- [ ] Dashboard cliente
- [ ] Dashboard profissional
- [ ] Fluxo de agendamento
- [ ] Integração AbacatePay

### Fase 3: DevOps (0% - Sprint 11+)

- [ ] Docker setup
- [ ] CI/CD pipeline
- [ ] Deploy em produção
- [ ] Monitoramento e logs

---

## 🔐 Segurança

### Atual (Sprint 1)
- ⚠️ **CRÍTICO:** API aberta (sem autenticação)
- ⚠️ Unique constraints incorretos
- ⚠️ Sem soft delete (dados perdidos ao deletar)

### Em Desenvolvimento (Sprint 1)
- 🟡 JWT Authentication
- 🟡 Spring Security roles
- 🟡 Password hashing (BCrypt)

### Futuro
- [ ] HTTPS/TLS em produção
- [ ] Rate limiting
- [ ] CORS configurado
- [ ] Input validation
- [ ] SQL injection prevention

---

## 🧪 Testes

### Atual
```bash
# Cobertura estimada: 10%
mvn test
```

### Próximo
- [ ] 70% cobertura de testes
- [ ] Testes unitários
- [ ] Testes de integração
- [ ] Testes E2E

### Testar API (com Postman/Insomnia)

```bash
# Registrar cliente
POST http://localhost:8080/customers/registerCustomer
Content-Type: application/json

{
  "name": "João Silva",
  "email": "joao@example.com",
  "phone": "(11) 99999-9999",
  "address": {
    "street": "Rua A",
    "number": "123",
    "city": "São Paulo",
    "state": "SP",
    "zipCode": "01234-567"
  }
}
```

---

## 📦 Dependências Principais

### Backend

```xml
<!-- Spring Boot Core -->
<spring-boot-starter-web>           <!-- Web, REST, JSON -->
<spring-boot-starter-data-jpa>      <!-- ORM, Hibernate -->
<spring-boot-starter-validation>    <!-- Bean validation -->
<spring-boot-starter-security>      <!-- Authentication (future) -->

<!-- Database -->
<mysql-connector-j>                 <!-- MySQL driver -->

<!-- Mapping -->
<mapstruct>                         <!-- DTO ↔ Entity mapping -->
<lombok>                            <!-- Boilerplate reduction -->

<!-- Testing -->
<spring-boot-starter-test>
```

### Frontend (Futuro)

```json
{
  "dependencies": {
    "react": "^18.0.0",
    "next": "^14.0.0",
    "@reduxjs/toolkit": "latest",
    "react-redux": "latest",
    "axios": "latest"
  },
  "devDependencies": {
    "typescript": "^5.0.0",
    "tailwindcss": "^3.0.0"
  }
}
```

---

## 🛠️ Troubleshooting

### Erro: "Can't connect to MySQL server"

```bash
# Verificar se MySQL está rodando
sudo systemctl status mysql

# Iniciar MySQL (se parado)
sudo systemctl start mysql

# Testar conexão
mysql -u barber -p -h localhost
```

### Erro: "Port 8080 already in use"

```bash
# Encontrar processo usando porta 8080
lsof -i :8080

# Matar processo
kill -9 <PID>

# Ou mudar porta em application.yaml
server:
  port: 8081
```

### Erro: Maven build fail

```bash
# Limpar cache Maven
mvn clean
mvn mvn install -U

# Reconstruir
mvn clean package
```

---

## 📈 Roadmap (12 Semanas até MVP)

### Semana 1-2: Débito Técnico ✅ (Em Progresso)
- [ ] Corrigir constraints
- [ ] Adicionar auditoria
- [ ] JWT authentication
- [ ] Soft delete

### Semana 3-4: Completar Cadastros
- [ ] GET endpoints com paginação
- [ ] Estender campos (foto, bio, especialidade)
- [ ] Validações customizadas

### Semana 5-6: Agendamento Core
- [ ] Domain model de agendamentos
- [ ] Validação de conflitos
- [ ] CRUD de 8 endpoints
- [ ] Notificações básicas

### Semana 7-8: Pagamento (AbacatePay)
- [ ] Setup AbacatePay
- [ ] Integração checkout
- [ ] Webhook handling
- [ ] Transferência automática

### Semana 9-10: Testes & Polimento
- [ ] 70% test coverage
- [ ] Performance optimization
- [ ] SEO básico

### Semana 11-12: Deploy & Go-Live
- [ ] Deploy em produção
- [ ] Landing page
- [ ] Primeiros usuários

---

## 🤝 Contribuindo

### Setup de Desenvolvimento

```bash
# 1. Fork o repositório
# 2. Clonar seu fork
git clone https://github.com/<seu-usuario>/ms-app-barber-plataform.git

# 3. Criar branch feature
git checkout -b feature/sua-feature

# 4. Fazer commits
git commit -am "Add: descrição da feature"

# 5. Push para branch
git push origin feature/sua-feature

# 6. Abrir Pull Request
```

### Padrões de Código

```java
// ✅ Bom
@Component
public class RegisterCustomerService {
    private final RegisterClientRepository repository;
    
    public void registerClient(ClientDTO dto) {
        // Implementação
    }
}

// ❌ Ruim
public class RegisterCustomerService {
    RegisterClientRepository repository = new RegisterClientRepository();
    
    public void registerClient(ClientDTO dto) {
        // Implementação
    }
}
```

### Commit Messages

```
feat: adicionar endpoint GET /customers
fix: corrigir unique constraint em email
docs: atualizar README com novo endpoint
refactor: reorganizar classes de autenticação
test: adicionar testes para RegisterCustomer
```

---

## 📚 Documentação Adicional

### Arquivos importantes
- [`docs/ARCHITECTURE.md`](docs/ARCHITECTURE.md) - Detalhes arquiteturais
- [`docs/API.md`](docs/API.md) - Documentação completa de API
- [`docs/SETUP.md`](docs/SETUP.md) - Guia detalhado de setup
- [`docs/ROADMAP.md`](docs/ROADMAP.md) - Roadmap de 12 semanas

### Recursos Externos
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Clean Architecture Guide](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [AbacatePay API Docs](https://docs.abacatepay.com)

---

## 📞 Suporte

### Issues
Para reportar bugs ou sugerir features:
1. Abra uma [Issue no GitHub](https://github.com/01122025/ms-app-barber-plataform/issues)
2. Use templates fornecidos
3. Descreva o problema/sugestão com detalhe

### Discussões
Perguntas gerais? Use [Discussions](https://github.com/01122025/ms-app-barber-plataform/discussions)

### Email
📧 []

---

## 📄 License

Este projeto está sob a licença MIT. Veja arquivo [LICENSE](LICENSE) para detalhes.

---

## 👥 Autores

- **Pedro (Founder/Developer)** - [@seu-github](https://github.com/01122025)

---

## 🙏 Agradecimentos

- Spring Boot community
- Clean Architecture pattern
- Comunidade de developers brasileiros

---

## 📊 Estatísticas do Projeto

| Métrica | Valor |
|---------|-------|
| **Linguagem Principal** | Java 21 |
| **Arquitetura** | Clean/Hexagonal |
| **Progresso Backend** | 35% |
| **Módulos** | 3 (Cliente, Profissional, Agendamento) |
| **Endpoints Implementados** | 6/32+ |
| **Cobertura de Testes** | ~10% |
| **Deadline MVP** | 12 semanas |

---

**Última atualização:** Agosto 2026  
**Status:** 🟡 Em Desenvolvimento (Sprint 1)

---

Desenvolvido com ❤️ para conectar profissionais e clientes de barbearia

