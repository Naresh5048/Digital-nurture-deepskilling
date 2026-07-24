import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        const postList = data.map(item => new Post(item.id, item.title, item.body));
        this.setState({ posts: postList });
      })
      .catch(err => {
        console.error("Failed to load posts:", err);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("An error occurred in the Posts component: " + error);
    this.setState({ hasError: true });
  }

  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong loading posts.</h2>;
    }

    return (
      <div style={{ padding: '20px' }}>
        <h2>Blog Posts</h2>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ marginBottom: '15px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;