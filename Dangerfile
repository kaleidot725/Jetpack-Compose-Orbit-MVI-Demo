# Warn when there is a big PR
warn("Big PR") if git.lines_of_code > 500

# ktlint
checkstyle_format.base_path = Dir.pwd
checkstyle_format.report 'app/build/reports/ktlint/ktlintMainSourceSetCheck/ktlintMainSourceSetCheck.xml'
checkstyle_format.report 'data/build/reports/ktlint/ktlintMainSourceSetCheck/ktlintMainSourceSetCheck.xml'
checkstyle_format.report 'domain/build/reports/ktlint/ktlintMainSourceSetCheck/ktlintMainSourceSetCheck.xml'
