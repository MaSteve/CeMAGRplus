{0} ssp 5;
{1} mst 0;
{2} cup 0 4;
{3} stp;
{ FUNC main }
{4} ssp 28;
{ €ret }
{5} lda 0 5;
{ := }
{6} ldc 0;
{ cte: 0 }
{7} sto;
{ €var1 }
{8} ldc 0;
{ := }
{ call: test1 }
{9} mst 1;
{10} ldc 3;
{ cte: 3 }
{11} ldc 10;
{ cte: 10 }
{12} cup 2 306;
{13} sto;
{ €var2 }
{14} ldc 1;
{ := }
{ call: test2 }
{15} mst 1;
{16} ldc 12;
{ cte: 12 }
{17} cup 1 178;
{18} sto;
{ €var3 }
{19} ldc 2;
{ := }
{ call: test3 }
{20} mst 1;
{21} ldc 5;
{ cte: 5 }
{22} cup 1 220;
{23} sto;
{ IF }
{ €var3 }
{24} ldc 2;
{25} ind;
{26} ldc 120;
{ cte: 120 }
{27} equ;
{ == }
{28} fjp 32;
{ THEN }
{ €ret }
{29} lda 0 5;
{ := }
{30} ldc 1111;
{ cte: 1111 }
{31} sto;
{ END IF }
{ €var4 }
{32} ldc 3;
{ := }
{ call: test5 }
{33} mst 1;
{34} ldc 2;
{ cte: 2 }
{35} cup 1 129;
{36} sto;
{ FOR }
{ €i }
{37} lda 0 26;
{ := }
{38} ldc 0;
{ cte: 0 }
{39} sto;
{ €i }
{40} lda 0 26;
{41} ind;
{42} ldc 5;
{ cte: 5 }
{43} les;
{ < }
{44} fjp 84;
{ DO }
{ FOR }
{ €j }
{45} lda 0 27;
{ := }
{46} ldc 0;
{ cte: 0 }
{47} sto;
{ €j }
{48} lda 0 27;
{49} ind;
{50} ldc 4;
{ cte: 4 }
{51} les;
{ < }
{52} fjp 77;
{ DO }
{ €arr }
{53} lda 0 6;
{ €j }
{54} lda 0 27;
{55} ind;
{56} chk 0 4;
{57} ixa 5;
{ €i }
{58} lda 0 26;
{59} ind;
{60} chk 0 5;
{61} ixa 1;
{[idx]}
{[idx]}
{ := }
{ €i }
{62} lda 0 26;
{63} ind;
{64} ldc 4;
{ cte: 4 }
{65} mul;
{ * }
{ €j }
{66} lda 0 27;
{67} ind;
{68} add;
{ + }
{69} sto;
{ €j }
{70} lda 0 27;
{ := }
{ €j }
{71} lda 0 27;
{72} ind;
{73} ldc 1;
{ cte: 1 }
{74} add;
{ + }
{75} sto;
{76} ujp 48;
{ END FOR }
{ €i }
{77} lda 0 26;
{ := }
{ €i }
{78} lda 0 26;
{79} ind;
{80} ldc 1;
{ cte: 1 }
{81} add;
{ + }
{82} sto;
{83} ujp 40;
{ END FOR }
{ €off }
{84} lda 0 26;
{ := }
{85} ldc 10;
{ cte: 10 }
{86} sto;
{ €var5 }
{87} ldc 4;
{ := }
{ call: test6 }
{88} mst 1;
{ €arr }
{89} lda 0 6;
{ €off }
{90} lda 0 26;
{91} cup 2 250;
{92} sto;
{ €ret }
{93} lda 0 5;
{94} ind;
{95} ldc 0;
{ cte: 0 }
{96} add;
{ + }
{97} str 0 0;
{ RETURN }
{98} retf;
{ END FUNC }
{ FUNC test4 }
{99} ssp 7;
{ IF }
{ €n }
{100} lda 0 5;
{101} ind;
{102} ldc 0;
{ cte: 0 }
{103} equ;
{ == }
{ €n }
{104} lda 0 5;
{105} ind;
{106} ldc 1;
{ cte: 1 }
{107} equ;
{ == }
{108} or;
{ or }
{109} fjp 114;
{ THEN }
{ €fact }
{110} lda 0 6;
{ := }
{111} ldc 1;
{ cte: 1 }
{112} sto;
{113} ujp 125;
{ ELSE }
{ €fact }
{114} lda 0 6;
{ := }
{ call: test3 }
{115} mst 1;
{ €n }
{116} lda 0 5;
{117} ind;
{118} ldc 1;
{ cte: 1 }
{119} sub;
{ - }
{120} cup 1 220;
{ €n }
{121} lda 0 5;
{122} ind;
{123} mul;
{ * }
{124} sto;
{ END IF }
{ €fact }
{125} lda 0 6;
{126} ind;
{127} str 0 0;
{ RETURN }
{128} retf;
{ END FUNC }
{ FUNC test5 }
{129} ssp 8;
{ SWITCH }
{ €n }
{130} lda 0 5;
{131} ind;
{132} dpl;
{133} ldc 1;
{134} geq;
{135} fjp 164;
{136} dpl;
{137} ldc 5;
{138} leq;
{139} fjp 164;
{140} ldc 1;
{141} sub;
{142} neg;
{143} ixj 173;
{ CASE 1 }
{ €ret }
{144} lda 0 6;
{ := }
{145} ldc 10;
{ cte: 10 }
{146} sto;
{147} ujp 174;
{ CASE 2 }
{ €auxi }
{148} lda 0 7;
{ := }
{149} ldc 5;
{ cte: 5 }
{150} sto;
{ €ret }
{151} lda 0 6;
{ := }
{ €auxi }
{152} lda 0 7;
{153} ind;
{ €auxi }
{154} lda 0 7;
{155} ind;
{156} mul;
{ * }
{157} sto;
{158} ujp 174;
{ CASE 5 }
{ €ret }
{159} lda 0 6;
{ := }
{160} ldc 2;
{ cte: 2 }
{161} neg;
{ - }
{162} sto;
{163} ujp 174;
{ DEFAULT }
{ €ret }
{164} lda 0 6;
{ := }
{165} ldc 1;
{ cte: 1 }
{166} neg;
{ - }
{167} sto;
{168} ujp 174;
{169} ujp 159;
{170} ujp 164;
{171} ujp 164;
{172} ujp 148;
{173} ujp 144;
{ END SWITCH }
{ €ret }
{174} lda 0 6;
{175} ind;
{176} str 0 0;
{ RETURN }
{177} retf;
{ END FUNC }
{ FUNC test2 }
{178} ssp 10;
{ €fib }
{179} lda 0 6;
{ := }
{180} ldc 0;
{ cte: 0 }
{181} sto;
{ €post }
{182} lda 0 7;
{ := }
{183} ldc 1;
{ cte: 1 }
{184} sto;
{ €i }
{185} lda 0 8;
{ := }
{186} ldc 1;
{ cte: 1 }
{187} sto;
{ WHILE }
{ €i }
{188} lda 0 8;
{189} ind;
{ €n }
{190} lda 0 5;
{191} ind;
{192} les;
{ < }
{193} fjp 216;
{ DO }
{ €auxi }
{194} lda 0 9;
{ := }
{ €fib }
{195} lda 0 6;
{196} ind;
{ €post }
{197} lda 0 7;
{198} ind;
{199} add;
{ + }
{200} sto;
{ €fib }
{201} lda 0 6;
{ := }
{ €post }
{202} lda 0 7;
{203} ind;
{204} sto;
{ €post }
{205} lda 0 7;
{ := }
{ €auxi }
{206} lda 0 9;
{207} ind;
{208} sto;
{ €i }
{209} lda 0 8;
{ := }
{ €i }
{210} lda 0 8;
{211} ind;
{212} ldc 1;
{ cte: 1 }
{213} add;
{ + }
{214} sto;
{215} ujp 188;
{ END WHILE }
{ €fib }
{216} lda 0 6;
{217} ind;
{218} str 0 0;
{ RETURN }
{219} retf;
{ END FUNC }
{ FUNC test3 }
{220} ssp 7;
{ IF }
{ €n }
{221} lda 0 5;
{222} ind;
{223} ldc 0;
{ cte: 0 }
{224} equ;
{ == }
{ €n }
{225} lda 0 5;
{226} ind;
{227} ldc 1;
{ cte: 1 }
{228} equ;
{ == }
{229} or;
{ or }
{230} fjp 235;
{ THEN }
{ €fact }
{231} lda 0 6;
{ := }
{232} ldc 1;
{ cte: 1 }
{233} sto;
{234} ujp 246;
{ ELSE }
{ €fact }
{235} lda 0 6;
{ := }
{ call: test4 }
{236} mst 1;
{ €n }
{237} lda 0 5;
{238} ind;
{239} ldc 1;
{ cte: 1 }
{240} sub;
{ - }
{241} cup 1 99;
{ €n }
{242} lda 0 5;
{243} ind;
{244} mul;
{ * }
{245} sto;
{ END IF }
{ €fact }
{246} lda 0 6;
{247} ind;
{248} str 0 0;
{ RETURN }
{249} retf;
{ END FUNC }
{ FUNC test6 }
{250} ssp 10;
{ €ret }
{251} lda 0 7;
{ := }
{ €off }
{252} lda 0 6;
{253} ind;
{254} ind;
{255} sto;
{ FOR }
{ €i }
{256} lda 0 8;
{ := }
{257} ldc 0;
{ cte: 0 }
{258} sto;
{ €i }
{259} lda 0 8;
{260} ind;
{261} ldc 5;
{ cte: 5 }
{262} les;
{ < }
{263} fjp 302;
{ DO }
{ FOR }
{ €j }
{264} lda 0 9;
{ := }
{265} ldc 0;
{ cte: 0 }
{266} sto;
{ €j }
{267} lda 0 9;
{268} ind;
{269} ldc 4;
{ cte: 4 }
{270} les;
{ < }
{271} fjp 295;
{ DO }
{ €ret }
{272} lda 0 7;
{ := }
{ €ret }
{273} lda 0 7;
{274} ind;
{ €arr }
{275} lda 0 5;
{276} ind;
{ €j }
{277} lda 0 9;
{278} ind;
{279} chk 0 4;
{280} ixa 5;
{ €i }
{281} lda 0 8;
{282} ind;
{283} chk 0 5;
{284} ixa 1;
{[idx]}
{[idx]}
{285} ind;
{286} add;
{ + }
{287} sto;
{ €j }
{288} lda 0 9;
{ := }
{ €j }
{289} lda 0 9;
{290} ind;
{291} ldc 1;
{ cte: 1 }
{292} add;
{ + }
{293} sto;
{294} ujp 267;
{ END FOR }
{ €i }
{295} lda 0 8;
{ := }
{ €i }
{296} lda 0 8;
{297} ind;
{298} ldc 1;
{ cte: 1 }
{299} add;
{ + }
{300} sto;
{301} ujp 259;
{ END FOR }
{ €ret }
{302} lda 0 7;
{303} ind;
{304} str 0 0;
{ RETURN }
{305} retf;
{ END FUNC }
{ FUNC test1 }
{306} ssp 9;
{ €ret }
{307} lda 0 7;
{ := }
{308} ldc 0;
{ cte: 0 }
{309} sto;
{ FOR }
{ €i }
{310} lda 0 8;
{ := }
{ €arg }
{311} lda 0 5;
{312} ind;
{313} sto;
{ €i }
{314} lda 0 8;
{315} ind;
{ €arg2 }
{316} lda 0 6;
{317} ind;
{318} leq;
{ <= }
{319} fjp 334;
{ DO }
{ €ret }
{320} lda 0 7;
{ := }
{ €ret }
{321} lda 0 7;
{322} ind;
{ €i }
{323} lda 0 8;
{324} ind;
{325} add;
{ + }
{326} sto;
{ €i }
{327} lda 0 8;
{ := }
{ €i }
{328} lda 0 8;
{329} ind;
{330} ldc 1;
{ cte: 1 }
{331} add;
{ + }
{332} sto;
{333} ujp 314;
{ END FOR }
{ €ret }
{334} lda 0 7;
{335} ind;
{336} str 0 0;
{ RETURN }
{337} retf;
{ END FUNC }
