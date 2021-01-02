for $xquery4 in doc('ProductBacklog.xml')/ProductBacklog/SNo[SolutionDescription] 
return 
<Data><LastCnt>{max($xquery4/@cnt)}</LastCnt> 
<SolvedCnt>{count($xquery4)}</SolvedCnt></Data> 
