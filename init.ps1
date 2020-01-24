$names = Get-ChildItem -recurse -Filter "*.md" -Name
$ScriptDir = Split-Path $script:MyInvocation.MyCommand.Path

Get-ChildItem -Recurse -Filter *.md | Rename-Item  -NewName { 'README.md' } 

#write $ScriptDir

Foreach ($name in $names) {
    $filePath = [System.IO.Path]::GetDirectoryName("$name")
    Set-Location -Path "$filePath" 

    $newFileName = [System.IO.Path]::GetFileName($filePath);

    git add './README.md'
    git commit -m "Fix : $newFileName"
    #git rm "$newFileName.md"
    #git commit -m "rm : $newFileName"
    
    Set-Location -Path  "$ScriptDir"
    
}

