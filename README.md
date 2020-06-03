# Roman Numerals Lab

A program to convert Roman Numerals to their respective Decimal values. Keep the following in mind:

* 7 basic Numerals (I, V, X, L, C, D, M)
* Case-insensitive
* Not allow Invalid Symbols (0, -ve numbers)
* Ignore whitespace
* Satisfy Addition rule
* Satisfy Repetition rule
* Satisfy Sorting rule
* Satisfy Subtraction rule

## Feature: Roman to Decimal Conversion  
  
In order to easily remember which games I want to watch.  
As Joe, a baseball league match follower,  
I want to convert Roman Numerals to Decimal Numbers  
  
### Scenario Outline: Seven Basic Numerals  
  
Given a roman digit  
When user enters \<roman\_digit\>  
Then \<decimal\_value\> should be displayed  
  
#### Examples:  

| roman\_digit | decimal\_value | comment                    |
| ------------ | -------------- | -------------------------- |
| I            | 1              | (one) (unus)               |
| V            | 5              | (five) (quinque)           |
| X            | 10             | (ten) (decem)              |
| L            | 50             | (fifty) (quinquaginta)     |
| C            | 100            | (one hundred) (centum)     |
| D            | 500            | (five hundred) (quingenti) |
| M            | 1000           | (one thousand) (mille)     |

  
#### Examples: Roman Numerals are case-insensitive  

| roman\_digit | decimal\_value |
| ------------ | -------------- |
| I            | 1              |
| i            | 1              |
| V            | 5              |
| v            | 5              |
| X            | 10             |
| x            | 10             |
| L            | 50             |
| l            | 50             |
| C            | 100            |
| c            | 100            |
| D            | 500            |
| d            | 500            |
| M            | 1000           |
| m            | 1000           |

  
### Scenario Outline: Invalid Roman Numerals are not allowed  
  
Given an invalid roman numeral  
When user enters \<roman\_number\>  
Then \<message\> should be displayed  
  
#### Examples:  

| roman\_number | message | comment                                            |
| ------------- | ------- | -------------------------------------------------- |
| 0             | Error   | Romans did not have the concept of zero            |
| \-i           | Error   | Romand did not have the concept of negative number |
| \-X           | Error   | Romand did not have the concept of negative number |
| null          | Error   | null is not valid                                  |
| blank         | Error   | blank is not valid                                 |
| a             | Error   | a is invalid                                       |
| A             | Error   | A is invalid                                       |
| Z             | Error   | Z is invalid                                       |
| z             | Error   | z is invalid                                       |

### Scenario Outline: Series of Roman Digits form a Romal Numeral

Given a series of roman digits
When user enters \<roman\_number\>
Then \<decimal\_value\> should be displayed

#### Examples: Addition Rules

The system of Roman numerals is a so-called additive system. Thus, the values of the used numeric symbols just have to be added in order to get the number represented.

| roman\_number | decimal\_value | comment                                                                         |
| ------------- | -------------- | ------------------------------------------------------------------------------- |
| C             | 100            | is valid                                                                        |
| CC            | 200            | is valid                                                                        |
| CCLXVII       | 267            | CCLXVII = C + C + L + X + V + I + I = 100 + 100 + 50 + 10 + 5 + 1 + 1 = 267     |
| mdclxvi       | 1666           | mdclxvi = m + d + c + l + x + v + i = 1000 + 500 + 100 + 50 + 10 + 5 + 1 = 1666 |
| VV            | Error          | V is not a power of ten. Only powers of ten (I, X, C, M) can be repeated.       |
| LL            | Error          | L is not a power of ten. Only powers of ten (I, X, C, M) can be repeated.       |
| DD            | Error          | D is not a power of ten. Only powers of ten can be repeated.                    |
| CCC           | 300            | is valid                                                                        |
| XXX           | 30             | is valid                                                                        |
| XXXXXXXXXX    | Error          | Any numeral cannot repeat more than 3 times                                     |
| IIII          | Error          | Any numeral cannot repeat more than 3 times                                     |

#### Examples: Sorting Rules

The rule of addition is complemented by the rule of sorting: The letters within a Roman numeral have to be sorted from left to right in descending order: Letters with the highest values are on the left; to the right the values decrease more and more. Thus, the Roman numeral CCLXVII cannot alternatively be written as, for instance, IIVXLCC.

| roman\_number | decimal\_value | comment                                                                                       |
| ------------- | -------------- | --------------------------------------------------------------------------------------------- |
| CCLXVII       | 267            | all the letters are sorted from left to right in descending order                             |
| IIVXLCC       | Error          | I is smaller than V which is smaller than X and so forth. They have to be in descending order |

#### Examples: Subtraction Rules  
If a Roman letter with a smaller value stands on the left of a letter with a higher value, then the smaller value is not added, but has to be subtracted from the larger. The result is then added to the rest of the letters. The rule of sorting makes it possible to write some numbers in a shorter notation?. For example, according to the rule of addition the value 44 is written as:  
  

|    |    |    |    |    |    |    |    |   |    |   |    |   |    |   |    |          |
| -- | -- | -- | -- | -- | -- | -- | -- | - | -- | - | -- | - | -- | - | -- | -------- |
| 10 | \+ | 10 | \+ | 10 | \+ | 10 | \+ | 1 | \+ | 1 | \+ | 1 | \+ | 1 | \= | 44       |
| X  |    | X  |    | X  |    | X  |    | I |    | I |    | I |    | I | \= | XXXXIIII |

  
The rule of subtraction makes it possible to write:  

|       |    |    |    |      |    |   |    |      |
| ----- | -- | -- | -- | ---- | -- | - | -- | ---- |
| (-10) | \+ | 50 | \+ | (-1) | \+ | 5 | \= | 44   |
| X     |    | L  |    | I    |    | V | \= | XLIV |


| roman\_number | decimal\_value | comment                                                                         |
| ------------- | -------------- | ------------------------------------------------------------------------------- |
| XCIX          | 99             | XCIX = (-)X + C + (-)I + X = (-10) + 100 + (-1) + 10 = 99                       |
| CCXLIII       | 243            | CCXLIII = C + C + (-)X + L + I + I +I = 100 + 100 + (50 - 10) + 1 + 1 + 1 = 243 |

  
#### Examples: Only one letter can be subtracted from another letter, not two or more  

| roman\_number | decimal\_value | comment                                                                       |
| ------------- | -------------- | ----------------------------------------------------------------------------- |
| CCM           | Error          | CCM isn't 800 because you can only subtract one letter from another, not two. |
| XXL           | Error          | XXL isn't 30 because you can only subtract one letter from another, not two.  |

#### Examples: Only powers of ten (I, X, C, M) can be subtracted.  
  

| roman\_number | decimal\_value | comment                                           |
| ------------- | -------------- | ------------------------------------------------- |
| IV            | 4              | Only powers of ten (I, X, C, M) can be subtracted |
| IX            | 9              | Only powers of ten (I, X, C, M) can be subtracted |
| XL            | 40             | Only powers of ten (I, X, C, M) can be subtracted |
| XC            | 90             | Only powers of ten (I, X, C, M) can be subtracted |
| CD            | 400            | Only powers of ten (I, X, C, M) can be subtracted |
| CM            | 900            | Only powers of ten (I, X, C, M) can be subtracted |
| VL            | Error          | VL isn't 45 because V (5) isn't a power of ten.   |

  
#### Examples: The smaller letter must be 1/5th (one-fifth) or 1/10th (one-tenth) the larger one.  
  

| roman\_number | decimal\_value | comment                                                      |
| ------------- | -------------- | ------------------------------------------------------------ |
| IC            | Error          | IC isn't 99 because I (1) is 1/100th of C (100), not 1/10th. |
| IL            | Error          | IL isn't 49 because I (1) is 1/50th of L (50), not 1/5th.    |

  
#### Examples: The smaller letter must be either the first numeral or preceded by a letter at least ten times greater than it.  
  

| roman\_number | decimal\_value | comment                                                           |
| ------------- | -------------- | ----------------------------------------------------------------- |
| DCM           | Error          | DCM isn't 1400 because D (500) is less than 1000 (10 \* 100 (C)). |

  
#### Examples: If another letter follows the larger one, it must be smaller than the number preceding the larger one.  
  

| roman\_number | decimal\_value | comment                                                 |
| ------------- | -------------- | ------------------------------------------------------- |
| XCL           | Error          | XCL isn't 140 because L (50) isn't smaller than X (10). |
| XCX           | Error          | XCX isn't 100 because X (10) isn't smaller than itself. |

  
#### Examples: White spaces should be ignored  
  

| roman\_number | decimal\_value | comment                                       |
| ------------- | -------------- | --------------------------------------------- |
| i             | 1              | ignore white spaces before numerals           |
| v             | 5              | ignore white spaces after numerals            |
| x             | 10             | ignore white spaces before and after numerals |
| l x           | 60             | ignore white spaces in between numerals       |
| c l x         | 160            | ignore white spaces in between numerals       |
