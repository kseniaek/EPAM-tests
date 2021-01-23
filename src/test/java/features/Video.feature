#@withdrawal
Function: Video

Scenario: Фильтрация докладов по категориям
Given main page open
When User navigates to the "Video" tab
And User clicks on "More Filters" button
Then The user clicks on "Category" in the filter box and selects "Testing" in the dropdown
Then The user clicks on "Location" in the filter box and selects "Belarus" in the dropdown
Then The user clicks on "Language" in the filter box and selects "English" in the dropdown
Then Page displays cards
| Testing |
| Belarus |
| English |

Scenario: Поиск докладов по ключевому слову
Given main page open
When User navigates to the "Video" tab
And User enters "QA" keyword into "search" box
Then Page displays cards
| QA |
  #На странице отображаются доклады, содержащие в названии ключевое слово поиска