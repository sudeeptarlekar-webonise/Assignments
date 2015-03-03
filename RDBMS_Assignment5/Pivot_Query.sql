set @ansSheet = null; 

select group_concat(Distinct concat('if(question = ''', question, ''',opption, null) AS ', quote(question))) into @ansSheet from Pivot;

set @sql = null;

set @sql = concat('select id,',@ansSheet,' from Pivot group by id');

prepare statement from @sql

execute statement;
