{0} ssp 1;
{1} mst 0;
{2} cup 0 4;
{3} stp;
{ FUNC main }
{4} ssp 13;
{ €V }
{5} lda 0 5;
{6} ldc 0;
{ cte: 0 }
{7} chk 0 4;
{8} ixa 1;
{[idx]}
{ := }
{9} ldc 1;
{ cte: 1 }
{10} sto;
{ €V }
{11} lda 0 5;
{12} ldc 1;
{ cte: 1 }
{13} chk 0 4;
{14} ixa 1;
{[idx]}
{ := }
{15} ldc 1;
{ cte: 1 }
{16} sto;
{ €V }
{17} lda 0 5;
{18} ldc 2;
{ cte: 2 }
{19} chk 0 4;
{20} ixa 1;
{[idx]}
{ := }
{21} ldc 0;
{ cte: 0 }
{22} sto;
{ €V }
{23} lda 0 5;
{24} ldc 3;
{ cte: 3 }
{25} chk 0 4;
{26} ixa 1;
{[idx]}
{ := }
{27} ldc 1;
{ cte: 1 }
{28} sto;
{ €i }
{29} lda 0 10;
{ := }
{30} ldc 3;
{ cte: 3 }
{31} sto;
{ €ceros }
{32} lda 0 11;
{ := }
{33} ldc 0;
{ cte: 0 }
{34} sto;
{ €unos }
{35} lda 0 12;
{ := }
{36} ldc 0;
{ cte: 0 }
{37} sto;
{ IF }
{ call: ej27 }
{38} mst 1;
{ €V }
{39} lda 0 5;
{40} ldc 0;
{ cte: 0 }
{ €i }
{41} lda 0 10;
{42} ind;
{ €ceros }
{43} lda 0 11;
{44} ind;
{ €unos }
{45} lda 0 12;
{46} ind;
{47} cup 5 61;
{48} fjp 53;
{ THEN }
{ €ret }
{49} lda 0 9;
{ := }
{50} ldc 0;
{ cte: 0 }
{51} sto;
{52} ujp 57;
{ ELSE }
{ €ret }
{53} lda 0 9;
{ := }
{54} ldc 1;
{ cte: 1 }
{55} neg;
{ - }
{56} sto;
{ END IF }
{ €ret }
{57} lda 0 9;
{58} ind;
{59} str 0 0;
{ RETURN }
{60} retf;
{ END FUNC }
{ FUNC ej27 }
{61} ssp 15;
{ IF }
{ €a }
{62} lda 0 6;
{63} ind;
{ €b }
{64} lda 0 7;
{65} ind;
{66} equ;
{ == }
{67} fjp 101;
{ THEN }
{ IF }
{ €V }
{68} lda 0 5;
{69} ind;
{ €a }
{70} lda 0 6;
{71} ind;
{72} chk 0 4;
{73} ixa 1;
{[idx]}
{74} ind;
{75} ldc 0;
{ cte: 0 }
{76} equ;
{ == }
{77} fjp 85;
{ THEN }
{ €ceros }
{78} lda 0 8;
{ := }
{ €ceros }
{79} lda 0 8;
{80} ind;
{81} ldc 1;
{ cte: 1 }
{82} add;
{ + }
{83} sto;
{84} ujp 101;
{ ELSE }
{ IF }
{ €V }
{85} lda 0 5;
{86} ind;
{ €a }
{87} lda 0 6;
{88} ind;
{89} chk 0 4;
{90} ixa 1;
{[idx]}
{91} ind;
{92} ldc 1;
{ cte: 1 }
{93} equ;
{ == }
{94} fjp 101;
{ THEN }
{ €unos }
{95} lda 0 9;
{ := }
{ €unos }
{96} lda 0 9;
{97} ind;
{98} ldc 1;
{ cte: 1 }
{99} add;
{ + }
{100} sto;
{ END IF }
{ END IF }
{ END IF }
{ IF }
{ €a }
{101} lda 0 6;
{102} ind;
{ €b }
{103} lda 0 7;
{104} ind;
{105} les;
{ < }
{106} fjp 159;
{ THEN }
{ €m }
{107} lda 0 11;
{ := }
{ €a }
{108} lda 0 6;
{109} ind;
{ €b }
{110} lda 0 7;
{111} ind;
{112} add;
{ + }
{113} ldc 2;
{ cte: 2 }
{114} div;
{ / }
{115} sto;
{ €aux1 }
{116} lda 0 13;
{ := }
{ call: ej27 }
{117} mst 1;
{ €V }
{118} lda 0 5;
{ €a }
{119} lda 0 6;
{120} ind;
{ €m }
{121} lda 0 11;
{122} ind;
{ €ceros }
{123} lda 0 8;
{124} ind;
{ €unos }
{125} lda 0 9;
{126} ind;
{127} cup 5 61;
{128} sto;
{ €aux2 }
{129} lda 0 14;
{ := }
{ call: ej27 }
{130} mst 1;
{ €V }
{131} lda 0 5;
{ €m }
{132} lda 0 11;
{133} ind;
{134} ldc 1;
{ cte: 1 }
{135} add;
{ + }
{ €b }
{136} lda 0 7;
{137} ind;
{ €ceros }
{138} lda 0 8;
{139} ind;
{ €unos }
{140} lda 0 9;
{141} ind;
{142} cup 5 61;
{143} sto;
{ IF }
{ €ceros }
{144} lda 0 8;
{145} ind;
{146} ldc 2;
{ cte: 2 }
{ €unos }
{147} lda 0 9;
{148} ind;
{149} mul;
{ * }
{150} equ;
{ == }
{151} fjp 156;
{ THEN }
{ €ret }
{152} lda 0 12;
{ := }
{153} ldc true;
{ bool: true }
{154} sto;
{155} ujp 159;
{ ELSE }
{ €ret }
{156} lda 0 12;
{ := }
{157} ldc false;
{ bool: false }
{158} sto;
{ END IF }
{ END IF }
{ €ret }
{159} lda 0 10;
{160} ind;
{161} str 0 0;
{ RETURN }
{162} retf;
{ END FUNC }
