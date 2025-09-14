# Build and Run

1. Clone the Repository.
2. Build and Run the Project.

# Languages, libraries and tools used

* REST API,
* Local caching,
* Retrofit,
* OkHttp,
* Jetpack Compose,
* MVVM,
* Clean Architecture,
* Kotlin Coroutines,
* Testing

# Application Description

This is an Android application for viewing characters and other information about the cartoon
"Rick and Morty".
The application interface is written in Jetpack Compose using Navigation, LazyColumn, and Paging 3.
The data source - [Rick and Morty](https://rickandmortyapi.com)

**The application consists of 3 screens:**

1. SCREEN_1 ***Characters*** - Paginating clickable list of cartoon characters.
2. SCREEN_2 ***Details*** - Characteristics of the hero selected on the SCREEN_1.
3. SCREEN_3 ***Locations*** - Paginating list of locations.

<img src="https://github.com/nolikstolikxxx/RickMortyComposeApp_Testing/blob/2fc8db1d6dbc409d36ee4f54cd872c7ec4ebc704/Screenshot_1.jpg" alt="jpg" width="360" height="800">
<img src="https://github.com/nolikstolikxxx/RickMortyComposeApp_Testing/blob/2fc8db1d6dbc409d36ee4f54cd872c7ec4ebc704/Screenshot_2.jpg" alt="jpg" width="360" height="800">
<img src="https://github.com/nolikstolikxxx/RickMortyComposeApp_Testing/blob/2fc8db1d6dbc409d36ee4f54cd872c7ec4ebc704/Screenshot_3.jpg" alt="jpg" width="360" height="800">

<img src="https://github.com/nolikstolikxxx/RickMortyComposeApp_Testing/blob/2fc8db1d6dbc409d36ee4f54cd872c7ec4ebc704/Video_1_App_General_Overview.mp4" alt="mp4" width="360" height="800">

# Description of UI-test scenarios

The main scenarios of the application are covered by UI-tests, using Kaspresso for this.

*Test #1*

### Context

On the main screen of the application, after loading the list of characters into a LazyColumn,
the following verification steps are performed:

#### Test Steps

1. The second item in the character list is selected.
2. The value in the Name field of this item is compared with the test’s expected value.
3. A click is performed on the selected character.
4. The screen corresponding to the selected character opens.
5. The value of the Name field on the character detail screen is compared with the same expected
   value as on the main screen.
6. It is confirmed that clicking on a specific character from the list opens the detail screen for
   that exact character.

#### Notes

1. The test checks the consistency of information between the list and the detail screen
   after navigation.
2. Validations are performed using the same test value for the Name field to ensure correct
   navigation and data display.

   ### Контекст
   На главном экране приложения, после загрузки списка персонажей в LazyColumn,
   выполняются следующие шаги проверки:
   #### Этапы теста
    1. Выбирается второй элемент списка персонажей.
    2. Значение поля "Name" данного элемента сравнивается с заданным в тесте ожиданием.
    3. Происходит клик по выбранному персонажу.
    4. Открывается экран, соответствующий выбранному персонажу.
    5. Значение поля "Name" на экране детали персонажа сравнивается с тем же ожидаемым значением,
       что и на главном экране.
    6. Подтверждается, что при клике на конкретного персонажа из списка открывается экран именно
       с этим персонажем.
   #### Примечания
    1. Тест проверяет согласованность информации между списком и экраном деталей после навигации.
    2. Валидации выполняются с использованием одного и того же тестового значения для поля "Name",
       чтобы убедиться в корректности перехода и отображения данных.

*Test #2*

### Context

The application is launched, and then the network connection is disabled via the adb server.
The test navigates to SCREEN_3 ***Locations***. The locations do not load due to the lack of
internet connectivity, and the screen should display a network-related notification together with
a retry button. The test locates the button on the screen and verifies the label on it
(compared to the expected value defined in the test).
In the after block, the network is re-enabled. This verifies the correct behavior
of the application when there is no internet connection.

#### Test Steps

1. Launch the application.
2. Disable the network connection via adb.
3. Navigate to SCREEN_3 ***Locations***.
4. Verify that the SCREEN_3 ***Locations*** do not load due to the lack of network.
5. Locate the retry button and verify the text on the button.
6. In the after block, re-enable the network.
7. Assess the correctness of the application's behavior when the internet connection is unavailable.

#### Notes

1. The test ensures that the user interface correctly responds to the absence of network and
   provides the option to retry.
2. Positive validation is achieved by matching the text on the button with the predefined value
   specified in the test.

   ### Контекст
   Приложение запускается, затем через adb-сервер выполняется отключение сетевого соединения.
   После этого тест переходит на экран №3 "Локации". "Локации" не загружаются из-за отсутствия
   интернет-соединения, и на экране должно отображаться уведомление об отсутствии сети вместе
   с кнопкой повторной загрузки. В тесте выполняется поиск кнопки на экране и проверка надписи
   на ней (сравнение с ожидаемым значением, заданным в тесте). В блоке "after" выполняется
   повторное включение сети. Таким образом проверяется корректное поведение приложения при
   отсутствии интернет-соединения.

   #### Этапы теста
    1. Запуск приложения.
    2. Отключение сетевого соединения через adb.
    3. Переход на экран 3 с локациями.
    4. Проверка отсутствия загрузки локаций из-за отсутствия сети.
    5. Поиск кнопки повторной загрузки и верификация текста на кнопке.
    6. В блоке after повторное включение сети.
    7. Оценка корректности поведения приложения при отключенном интернет-соединении.

   #### Примечания
    1. Тест удостоверяется, что пользовательский интерфейс корректно реагирует на отсутствие сети
       и предоставляет возможность повторной загрузки.
    2. Позитивная валидация достигается за счет сопоставления текста на кнопке с заранее заданным
       в тесте значением.

<img src="https://github.com/nolikstolikxxx/RickMortyComposeApp_Testing/blob/2fc8db1d6dbc409d36ee4f54cd872c7ec4ebc704/Screenshot_4_NoInternetTest.jpg" alt="jpg" width="360" height="800">
<img src="https://github.com/nolikstolikxxx/RickMortyComposeApp_Testing/blob/aeccdc5d32116a97f827659d9da10d3c927f16f2/Video_2_NoInternetTest.gif" alt="gif" width="360" height="800">

# Unit Testing

- [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver)
  A scriptable web server for testing HTTP clients
- [Mockito](https://site.mockito.org/) Mocking framework for unit tests
- [Truth](https://truth.dev/) is a library for performing assertions in tests:
- [Turbine](https://github.com/cashapp/turbine) is a small testing library for kotlinx.coroutines
  Flow.