<?php

// Start of ctype v.

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for alphanumeric character(s)
 * @link http://php.net/manual/en/function.ctype-alnum.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in text is either
 * a letter or a digit, false otherwise.
 */
function ctype_alnum ($text) {}

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for alphabetic character(s)
 * @link http://php.net/manual/en/function.ctype-alpha.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in text is 
 * a letter from the current locale, false otherwise.
 */
function ctype_alpha ($text) {}

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for control character(s)
 * @link http://php.net/manual/en/function.ctype-cntrl.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in text is 
 * a control character from the current locale, false otherwise.
 */
function ctype_cntrl ($text) {}

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for numeric character(s)
 * @link http://php.net/manual/en/function.ctype-digit.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in the string
 * text is a decimal digit, false otherwise.
 */
function ctype_digit ($text) {}

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for lowercase character(s)
 * @link http://php.net/manual/en/function.ctype-lower.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in text is 
 * a lowercase letter in the current locale.
 */
function ctype_lower ($text) {}

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for any printable character(s) except space
 * @link http://php.net/manual/en/function.ctype-graph.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in text is 
 * printable and actually creates visible output (no white space), false
 * otherwise.
 */
function ctype_graph ($text) {}

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for printable character(s)
 * @link http://php.net/manual/en/function.ctype-print.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in text 
 * will actually create output (including blanks). Returns false if 
 * text contains control characters or characters 
 * that do not have any output or control function at all.
 */
function ctype_print ($text) {}

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for any printable character which is not whitespace or an
   alphanumeric character
 * @link http://php.net/manual/en/function.ctype-punct.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in text 
 * is printable, but neither letter, digit or blank, false otherwise.
 */
function ctype_punct ($text) {}

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for whitespace character(s)
 * @link http://php.net/manual/en/function.ctype-space.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in text 
 * creates some sort of white space, false otherwise. Besides the 
 * blank character this also includes tab, vertical tab, line feed,
 * carriage return and form feed characters.
 */
function ctype_space ($text) {}

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for uppercase character(s)
 * @link http://php.net/manual/en/function.ctype-upper.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in text is 
 * an uppercase letter in the current locale.
 */
function ctype_upper ($text) {}

/**
 * (PHP 4 &gt;= 4.0.4, PHP 5)<br/>
 * Check for character(s) representing a hexadecimal digit
 * @link http://php.net/manual/en/function.ctype-xdigit.php
 * @param string $text <p>
 * The tested string.
 * </p>
 * @return bool true if every character in text is 
 * a hexadecimal 'digit', that is a decimal digit or a character from 
 * [A-Fa-f] , false otherwise.
 */
function ctype_xdigit ($text) {}

// End of ctype v.
?>
