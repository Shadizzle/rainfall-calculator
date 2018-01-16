# Rainfall Calculator

Implement a Rainfall Calculator using functional programming constructs (map, filter, fold, etc).

Create a program that reads a list of numbers representing daily rainfall.  The list contains integers where -999 terminates the data to be processed.
Return the average of the non-negative integers up to, and not including, the first -999.

For example:
[1,1,1,1,1,1,1,1,1,-999] -> 1
[1,2,3,4,5,-999] -> 3
[1,-1,-999] -> 1
[-999]  -> No result (Nothing)
[1,-1,9,0,10,99,-999,0,1,...] -> 23.8

## Requirements

You will need to install the Clojure command line tools, you can find the ["Getting Started" page here](https://clojure.org/guides/getting_started).

## Usage

To calculate the average of any number of lists of integers, you must run the following command from the project root:
```
clj -m rainfall "[list 1]" "[list 2]" ...
```

Run all of the examples provided in the task description like so:
```
clj -m rainfall "[1,1,1,1,1,1,1,1,1,-999]" "[1,2,3,4,5,-999]" "[1,-1,-999]" "[-999]" "[1,-1,9,0,10,99,-999,0,1]"
```

Which should print the following:
```
[1 1 1 1 1 1 1 1 1 -999] -> 1.0
[1 2 3 4 5 -999] -> 3.0
[1 -1 -999] -> 1.0
[-999] -> :no-result
[1 -1 9 0 10 99 -999 0 1] -> 23.
```
