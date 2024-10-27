# Stage all changes
git add .

# Initialize an empty commit message variable
commit_message=""

# Loop over each staged file to get the first line
for file in $(git diff --cached --name-only); do
    # Read the first line of the file
    first_line=$(head -n 1 "$file")

    # Append the first line to the commit message
    commit_message+="$first_line"$'\n'
done

# Commit with the generated commit message
git commit -m "$commit_message"
