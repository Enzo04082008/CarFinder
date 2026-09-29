# 🚗 CarFinder

Aplicativo Android para busca e gerenciamento de veículos, desenvolvido com **Kotlin** e **Jetpack Compose**.

---

## 🏗️ Arquitetura do Projeto

O projeto foi estruturado utilizando princípios de **Clean Architecture** e módulos por camada/funcionalidade para permitir o desenvolvimento paralelo por múltiplos programadores sem conflitos de merge no Git.

```text
com.example.carfinder/
│
├── data/                      # Camada de Dados (Modelos, Repositórios, APIs)
│   ├── model/
│   │   └── Car.kt             # Modelo de dados principal do Veículo
│   └── repository/
│       └── CarRepository.kt   # Repositório de dados (Local/Remoto)
│
├── ui/                        # Camada de Interface do Usuário (Jetpack Compose)
│   ├── components/            # Componentes visuais reutilizáveis
│   │   └── CarCard.kt
│   ├── navigation/            # Rotas e navegação do app
│   ├── screens/               # Telas organizadas por funcionalidade
│   │   ├── home/              # Tela Principal / Destaques
│   │   ├── search/            # Tela de Busca e Filtros
│   │   └── details/           # Tela de Detalhes do Veículo
│   └── theme/                 # Cores, Tipografia e Tema Material 3
│
└── MainActivity.kt            # Ponto de entrada da aplicação
```

---

## 👥 Divisão de Tarefas Sugerida (Time de 3 Pessoas)

### 👤 Desenvolvedor 1: **Módulo Home & Componentes Base**
* **Responsabilidades:**
  * Desenvolvimento da tela principal (`HomeScreen.kt`).
  * Criação de componentes UI reutilizáveis em `ui/components/` (`CarCard.kt`, TopBars, Badges).
  * Design System e ajustes no tema (`ui/theme/`).

### 👤 Desenvolvedor 2: **Módulo de Busca, Filtros & Dados**
* **Responsabilidades:**
  * Tela de Busca e Filtros (`SearchScreen.kt`).
  * Expansão dos modelos de dados em `data/model/` e repositórios em `data/repository/`.
  * Integração com fonte de dados externa (API REST / Room Database).

### 👤 Desenvolvedor 3: **Módulo de Detalhes, Navegação & Favoritos**
* **Responsabilidades:**
  * Tela de Detalhes do Veículo (`DetailScreen.kt`).
  * Configuração do `NavigationHost` e rotas entre as telas.
  * Funcionalidade de Favoritos e persistência do estado da sessão.

---

## 🌿 Fluxo de Trabalho do Git (Git Flow)

Para evitar conflitos durante a colaboração:

1. **Branch Principal (`main`):**
   * Contém código estável e pronto para testes/produção. Ninguém deve fazer `push` direto na `main`.

2. **Branches de Funcionalidade (`feature/`):**
   * Cada dev cria uma branch para sua tarefa a partir da `main`:
     * `git checkout -b feature/home-screen` (Dev 1)
     * `git checkout -b feature/search-filters` (Dev 2)
     * `git checkout -b feature/navigation-details` (Dev 3)

3. **Pull Requests (PRs):**
   * Ao finalizar uma tarefa, faça o push da sua branch e abra um **Pull Request** para a `main`.
   * Solicite a revisão de pelo menos um colega antes de fazer o merge.

---

## 🛠️ Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```
2. Abra o projeto no **Android Studio**.
3. Aguarde a sincronização do Gradle (**Gradle Sync**).
4. Execute o app em um emulador ou dispositivo físico com Android 11+ (API 30+).
