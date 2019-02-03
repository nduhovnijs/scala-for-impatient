/*
Number of 'case' labels in JDK source code:
  haven:jdk_source nduhovnijs$ grep -Er "case [^:]+:" ./* | wc -l
     10119

Number of 'case' labels in JDK source code, where fall through is happening
(meaning that "break" was not used intentionally):
  haven:jdk_source nduhovnijs$ grep -Er "case [^:]+:" ./* | grep -i 'fall' | wc -l
    6

Which means that omitting "break" is very rarely used and it would be more
optimal to have "break" behaviour by default.
*/
