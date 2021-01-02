for $xquery1 in doc('ProductBacklog.xml')/ProductBacklog/SNo 
return 
<Data><LastCnt>{max($xquery1/@cnt)}</LastCnt> 
<SolvedCnt>{count($xquery1/SolutionDescription)}</SolvedCnt></Data>
