exports.handler = async (event) => {
    console.log(event)
    const postsId = event.pathParameters.postsId;
    const posts = {'postsID': postsId};
    const response = {
        statusCode: 200,
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Headers": "*"
        },
        body: JSON.stringify(posts),
        };
        return response;
};
    
